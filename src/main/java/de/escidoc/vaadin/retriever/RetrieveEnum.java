/**
 * 
 */
package de.escidoc.vaadin.retriever;

/**
 * @author ASP
 *
 */
public enum RetrieveEnum {
    RETRIEVE_ITEMS("retrieveItems"),
    RETRIEVE_CONTAINERS("retrieveContainers"),
    RETRIEVE_MEMBERS("retrieveMembers"),
    RETRIEVE_GRANTS("retrieveGrants"),
    RETRIEVE_USER_ACCOUNTS("retrieveUserAccounts"),
    RETRIEVE_CONTEXTS("retrieveContexts"),
    ;
    
    
    private String cmd;
    
    private RetrieveEnum(String cmd){
        this.cmd = cmd;
    }

    /**
     * @return the cmd
     */
    public final String getCmd() {
        return cmd;
    }
    
    
}
