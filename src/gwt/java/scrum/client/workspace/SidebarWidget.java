package scrum.client.workspace;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class SidebarWidget extends Composite {

	public SidebarWidget() {
		VerticalPanel sidebar = new VerticalPanel();
		sidebar.setStyleName("SidebarWidget");
		sidebar.setWidth("140px");
		sidebar.setHeight("300px");

		sidebar.add(new HTML("<h3>sidebar</h3>"));

		Button summaryButton = new Button("Project Summary");
		summaryButton.addClickListener(new SummaryClickListener());
		sidebar.add(summaryButton);

		Button backlogButton = new Button("Product Backlog");
		backlogButton.addClickListener(new BacklogClickListener());
		sidebar.add(backlogButton);

		Button impedimentsButton = new Button("Impediments");
		impedimentsButton.addClickListener(new ImpedimentsClickListener());
		sidebar.add(impedimentsButton);

		initWidget(sidebar);
	}

	private class ImpedimentsClickListener implements ClickListener {

		public void onClick(Widget sender) {
			WorkspaceWidget.showImpediments();
		}
	}

	private class SummaryClickListener implements ClickListener {

		public void onClick(Widget sender) {
			WorkspaceWidget.showSummary();
		}
	}

	private class BacklogClickListener implements ClickListener {

		public void onClick(Widget sender) {
			WorkspaceWidget.showBacklog();
		}
	}
}
