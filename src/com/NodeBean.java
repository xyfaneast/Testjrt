/**
 * 
 */
package com;

/**
 * @author fandong
 * @date 2018年11月19日 上午10:50:17 
 * @desc IT工作平台系统--节点对象，操作5响应使用
 */
public class NodeBean {

    private String nodeId;//当前节点ID
    private String directNodeId;//目标节点ID
    private String directNodeName;//目标节点名称
    private String directNodeKind;//目标节点类型
    private String orgScope;//机构范围
    private String orgScopeId;//指定机构ID
    private String roleCode;//节点角色

    public NodeBean() {}

    public NodeBean(String nodeId, String directNodeId, String directNodeName, String directNodeKind, String orgScope,
            String orgScopeId, String roleCode) {
        super();
        this.nodeId = nodeId;
        this.directNodeId = directNodeId;
        this.directNodeName = directNodeName;
        this.directNodeKind = directNodeKind;
        this.orgScope = orgScope;
        this.orgScopeId = orgScopeId;
        this.roleCode = roleCode;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getDirectNodeId() {
        return directNodeId;
    }

    public void setDirectNodeId(String directNodeId) {
        this.directNodeId = directNodeId;
    }

    public String getDirectNodeName() {
        return directNodeName;
    }

    public void setDirectNodeName(String directNodeName) {
        this.directNodeName = directNodeName;
    }

    public String getDirectNodeKind() {
        return directNodeKind;
    }

    public void setDirectNodeKind(String directNodeKind) {
        this.directNodeKind = directNodeKind;
    }

    public String getOrgScope() {
        return orgScope;
    }

    public void setOrgScope(String orgScope) {
        this.orgScope = orgScope;
    }

    public String getOrgScopeId() {
        return orgScopeId;
    }

    public void setOrgScopeId(String orgScopeId) {
        this.orgScopeId = orgScopeId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    
}
