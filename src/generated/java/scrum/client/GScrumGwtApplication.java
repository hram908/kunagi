









// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.gen.GwtApplicationGenerator










package scrum.client;

import java.util.*;

public abstract class GScrumGwtApplication
            extends scrum.client.AGwtApplication {

    // --- scrum service ---

    private ScrumServiceAsync scrumService;

    public final ScrumServiceAsync getScrumService() {
        if (scrumService == null) {
            scrumService = com.google.gwt.core.client.GWT.create(ScrumService.class);
            ((com.google.gwt.user.client.rpc.ServiceDefTarget) scrumService).setServiceEntryPoint(com.google.gwt.core.client.GWT.getModuleBaseURL() + "scrum");
        }
        return scrumService;
    }

    public final void callLogin(java.lang.String username, java.lang.String password,  Runnable callback) {
        getScrumService().login(username, password,  new DefaultCallback(callback));
    }

    public final void callLogin(java.lang.String username, java.lang.String password) {
        callLogin(username, password,  null);
    }

    public final void callSelectProject(java.lang.String projectId,  Runnable callback) {
        getScrumService().selectProject(projectId,  new DefaultCallback(callback));
    }

    public final void callSelectProject(java.lang.String projectId) {
        callSelectProject(projectId,  null);
    }

    public final void callRequestImpediments( Runnable callback) {
        getScrumService().requestImpediments( new DefaultCallback(callback));
    }

    public final void callRequestImpediments() {
        callRequestImpediments( null);
    }

    public final void callRequestBacklogItems( Runnable callback) {
        getScrumService().requestBacklogItems( new DefaultCallback(callback));
    }

    public final void callRequestBacklogItems() {
        callRequestBacklogItems( null);
    }

    public final void callRequestCurrentSprint( Runnable callback) {
        getScrumService().requestCurrentSprint( new DefaultCallback(callback));
    }

    public final void callRequestCurrentSprint() {
        callRequestCurrentSprint( null);
    }

    public final void callChangeProperties(java.lang.String entityId, java.util.Map properties,  Runnable callback) {
        getScrumService().changeProperties(entityId, properties,  new DefaultCallback(callback));
    }

    public final void callChangeProperties(java.lang.String entityId, java.util.Map properties) {
        callChangeProperties(entityId, properties,  null);
    }

    public final void callCreateEntity(java.lang.String type, java.util.Map properties,  Runnable callback) {
        getScrumService().createEntity(type, properties,  new DefaultCallback(callback));
    }

    public final void callCreateEntity(java.lang.String type, java.util.Map properties) {
        callCreateEntity(type, properties,  null);
    }

    public final void callDeleteEntity(java.lang.String entityId,  Runnable callback) {
        getScrumService().deleteEntity(entityId,  new DefaultCallback(callback));
    }

    public final void callDeleteEntity(java.lang.String entityId) {
        callDeleteEntity(entityId,  null);
    }

    public final void callSleep(long millis,  Runnable callback) {
        getScrumService().sleep(millis,  new DefaultCallback(callback));
    }

    public final void callSleep(long millis) {
        callSleep(millis,  null);
    }

}