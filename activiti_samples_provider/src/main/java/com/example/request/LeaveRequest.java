package com.example.request;

import com.example.model.activiti.ProcessLeave;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author yanzt
 * @date 2018/11/28 22:30
 * @describe
 */
@Data
public class LeaveRequest implements Serializable {

    @NotEmpty(message = "不能为空")
    public String text;

    @Valid
    @NotNull(message = "props不能为空")
    @Size(min = 1, message = "props至少要有一个自定义属性")
    private List<ProcessLeave> processLeaves;
}
