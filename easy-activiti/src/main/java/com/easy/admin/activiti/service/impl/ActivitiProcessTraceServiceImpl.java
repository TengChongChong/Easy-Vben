package com.easy.admin.activiti.service.impl;

import com.easy.admin.activiti.config.manager.CustomProcessDiagramGenerator;
import com.easy.admin.activiti.constant.ActivitiWorkflowConst;
import com.easy.admin.activiti.service.ActivitiProcessTraceService;
import com.easy.admin.common.core.constant.CommonConst;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 流程跟踪
 *
 * @author TengChongChong
 * @date 2020/4/29
 */
@Service
public class ActivitiProcessTraceServiceImpl implements ActivitiProcessTraceService {
    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ProcessEngineConfiguration processEngineConfiguration;

    /**
     * 读取动态流程图
     */
    @Override
    public void readProcessImg(String processInstanceId, HttpServletResponse response) throws IOException {
        HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
        ProcessDefinitionEntity definitionEntity = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(processInstance.getProcessDefinitionId());
        List<HistoricActivityInstance> highLightedActivitList = historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId).orderByHistoricActivityInstanceStartTime().asc().list();
        // 高亮环节id集合
        List<String> highLightedActivitis = new ArrayList<String>();
        // 高亮线路id集合
        List<String> highLightedFlows = getHighLightedFlows(definitionEntity, highLightedActivitList);
        for (HistoricActivityInstance tempActivity : highLightedActivitList) {
            String activityId = tempActivity.getActivityId();
            highLightedActivitis.add(activityId);
        }

        Set<String> currIds = runtimeService.createExecutionQuery().processInstanceId(processInstance.getId()).list()
                .stream().map(e -> e.getActivityId()).collect(Collectors.toSet());

        CustomProcessDiagramGenerator diagramGenerator = (CustomProcessDiagramGenerator) processEngineConfiguration.getProcessDiagramGenerator();
        InputStream imageStream = diagramGenerator.generateDiagram(
                bpmnModel,
                "png",
                highLightedActivitis,
                highLightedFlows,
                ActivitiWorkflowConst.TYPEFACE,
                ActivitiWorkflowConst.TYPEFACE,
                ActivitiWorkflowConst.TYPEFACE,
                null,
                1.0,
                new Color[]{ActivitiWorkflowConst.COLOR_NORMAL, ActivitiWorkflowConst.COLOR_CURRENT},
                currIds);
        // 输出资源内容到相应对象
        byte[] b = new byte[1024];
        int len;
        while ((len = imageStream.read(b, 0, CommonConst.BYTE1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
    }

    /**
     * 获取需要高亮的线
     *
     * @param processDefinitionEntity 流程实例
     * @param historicActivityInstances 历史活动
     * @return 高亮 flows
     */
    private List<String> getHighLightedFlows(ProcessDefinitionEntity processDefinitionEntity,
                                             List<HistoricActivityInstance> historicActivityInstances) {
        // 用以保存高亮的线flowId
        List<String> highFlows = new ArrayList<>();
        // 对历史流程节点进行遍历
        for (int i = 0; i < historicActivityInstances.size() - 1; i++) {
            HistoricActivityInstance iThisHis = historicActivityInstances.get(i);
            // 用以保存后结束时间相同的节点
            List<ActivityImpl> endTimeNodes = new ArrayList<>();
            if (iThisHis.getEndTime() != null) {
                // 对历史流程节点进行遍历
                for (int j = i + 1; j < historicActivityInstances.size(); j++) {
                    HistoricActivityInstance jThisHis = historicActivityInstances.get(j);
                    // 如果第2个节点结束时间相同保存
                    if (iThisHis.getEndTime().compareTo(jThisHis.getStartTime()) == 0) {
                        ActivityImpl jActivity = processDefinitionEntity.findActivity(jThisHis.getActivityId());
                        endTimeNodes.add(jActivity);
                    }
                }
                ActivityImpl iActivity = processDefinitionEntity.findActivity(iThisHis.getActivityId());
                // 取出节点的所有出去的线
                List<PvmTransition> pvmTransitions = iActivity.getOutgoingTransitions();
                for (PvmTransition pvmTransition : pvmTransitions) {
                    // 对所有的线进行遍历
                    ActivityImpl pvmActivityImpl = (ActivityImpl) pvmTransition.getDestination();
                    // 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
                    if (endTimeNodes.contains(pvmActivityImpl)) {
                        highFlows.add(pvmTransition.getId());
                    }
                }
            }
        }
        return highFlows;
    }


}
