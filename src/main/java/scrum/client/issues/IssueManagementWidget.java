package scrum.client.issues;

import ilarkesto.gwt.client.ButtonWidget;
import ilarkesto.gwt.client.Gwt;
import scrum.client.common.AScrumWidget;
import scrum.client.common.BlockListWidget;
import scrum.client.project.Project;
import scrum.client.workspace.PagePanel;

import com.google.gwt.user.client.ui.Widget;

public class IssueManagementWidget extends AScrumWidget {

	public BlockListWidget<Issue> openList;
	public BlockListWidget<Issue> acceptedList;
	public BlockListWidget<Issue> suspendedList;
	public BlockListWidget<Issue> closedList;

	@Override
	protected Widget onInitialization() {
		cm.getApp().callRequestIssues();

		openList = new BlockListWidget<Issue>(IssueBlock.FACTORY);
		openList.setAutoSorter(Issue.ISSUE_DATE_COMPARATOR);

		acceptedList = new BlockListWidget<Issue>(IssueBlock.FACTORY);
		acceptedList.setAutoSorter(Issue.ACCEPT_DATE_COMPARATOR);

		suspendedList = new BlockListWidget<Issue>(IssueBlock.FACTORY);
		suspendedList.setAutoSorter(Issue.SUSPEND_DATE_COMPARATOR);

		closedList = new BlockListWidget<Issue>(IssueBlock.FACTORY);
		closedList.setAutoSorter(Issue.CLOSE_DATE_COMPARATOR);

		PagePanel pendingPage = new PagePanel();
		pendingPage.addHeader("issue inbox (decision required)", new ButtonWidget(new CreateIssueAction()));
		pendingPage.addSection(openList);

		return Gwt.createFlowPanel(pendingPage, Gwt.createSpacer(1, 10), PagePanel.createSimple(
			"urgent issues (Team needs to fix this)", acceptedList), Gwt.createSpacer(1, 10), PagePanel.createSimple(
			"accepted issues (ideas and candidates for stories)", suspendedList), Gwt.createSpacer(1, 10), PagePanel
				.createSimple("closed issues (done or rejected)", closedList));
	}

	@Override
	protected void onUpdate() {
		super.onUpdate();
		Project project = getCurrentProject();
		openList.setObjects(project.getOpenIssues());
		acceptedList.setObjects(project.getUrgentIssues());
		suspendedList.setObjects(project.getSusendedIssues());
		closedList.setObjects(project.getClosedIssues());
	}

	public boolean select(Issue issue) {
		update();
		if (openList.showObject(issue)) return true;
		if (acceptedList.showObject(issue)) return true;
		if (suspendedList.showObject(issue)) return true;
		if (closedList.showObject(issue)) return true;
		return false;
	}
}