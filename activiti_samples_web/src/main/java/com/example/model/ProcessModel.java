package com.example.model;

import com.example.constant.ProcessModelStates;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    private int modelStates;

    @NotBlank(message = "模型名称不能为空")
    @Column(name = "model_name")
    private String modelName;

    @NotBlank(message = "模型编码不能为空")
    @Column(name = "model_code")
    private String modelCode;

    @Column(name = "activi_model_id")
    private Long activiModelId;

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

    public String getModelStatesName(){
        return ProcessModelStates.getName(this.getModelStates());
    }
}
