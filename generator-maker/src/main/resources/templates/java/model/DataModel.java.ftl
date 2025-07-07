package ${basePackage}.model;

import lombok.Data;

/**
* Defines the configuration for the template. Used for dynamic generation.
*/
@Data
public class DataModel {
<#list modelConfig.models as modelInfo>

    <#if modelInfo.description??>
    /**
    * ${modelInfo.description}
    */
    </#if>
    private ${modelInfo.type} ${modelInfo.fieldName}<#if modelInfo.defaultValue??> = ${modelInfo.defaultValue?c}</#if>;
</#list>
}
