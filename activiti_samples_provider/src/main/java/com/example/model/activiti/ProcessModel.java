package com.example.model.activiti;

import com.example.constant.ProcessModelStates;
import com.example.model.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/14 14:43
 * @desc
 */
@Data
@Entity
@Table(name = "process_model")
public class ProcessModel extends BaseModel<Long> implements Serializable {

    @Column(name = "model_states")
    private Integer modelStates;

    @NotBlank(message = "模型名称不能为空")
    @Column(name = "model_name")
    private String modelName;

    @NotBlank(message = "模型编码不能为空")
    @Column(name = "model_code")
    private String modelCode;

    @Column(name = "activi_model_id")
    private String activiModelId;

    @Column(name = "model_type_code")
    private String modelTypeCode;

    @Column(name = "model_type_name")
    private String modelTypeName;

    @Column(name = "model_org_name")
    private String modelOrgName;

    @Column(name = "model_org_code")
    private String modelOrgCode;

    @Column(name = "model_desc")
    private String modelDesc;

    @Column(name = "model_corp_name")
    private String modelCorpName;

    @Column(name = "model_corp_code")
    private String modelCorpCode;

    @Column(name = "model_version")
    private Long modelVersion;

    @Column(name = "process_definition_id")
    private String modelDefinitionId;

    @Column(name = "process_definition_key")
    private String modelDefinitionKey;

    @Column(name = "deployment_id")
    private String deploymentId;

    public String getModelStatesName(){
        return ProcessModelStates.getName(this.getModelStates());
    }
}
