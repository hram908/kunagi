package scrum.client.project;

import scrum.client.common.BlockListWidget;
import scrum.client.common.Gwt;
import scrum.client.service.Service;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class BacklogItemListWidget extends Composite {

	public BlockListWidget list;

	public BacklogItemListWidget() {
		Button createButton = new Button("Create new Backlog-Item");
		createButton.addClickListener(new CreateClickListener());

		HorizontalPanel toolbar = new HorizontalPanel();
		toolbar.setWidth("100%");
		toolbar.setStyleName("Toolbar");
		toolbar.add(createButton);
		Gwt.addFiller(toolbar);

		list = new BlockListWidget();
		for (BacklogItem item : Service.getProject().getBacklogItems()) {
			list.addBlock(new BacklogItemWidget(item));
		}

		FlowPanel panel = new FlowPanel();
		panel
				.add(new Label(
						"The product backlog (or \"backlog\") is the requirements for a system, expressed as a prioritized list of product backlog Items. These included both functional and non-functional customer requirements, as well as technical team-generated requirements. While there are multiple inputs to the product backlog, it is the sole responsibility of the product owner to prioritize the product backlog."));
		panel.add(new HTML("<br>"));
		panel.setWidth("100%");
		panel.add(toolbar);
		panel.add(new HTML("<br>"));
		panel.add(list);
		initWidget(panel);
	}

	class CreateClickListener implements ClickListener {

		public void onClick(Widget sender) {
			BacklogItem item = Service.getProject().createNewBacklogItem();
			BacklogItemWidget block = new BacklogItemWidget(item);
			list.addBlock(block);
			list.selectBlock(block);
		}
	}
}