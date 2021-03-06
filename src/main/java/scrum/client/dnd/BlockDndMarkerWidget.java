package scrum.client.dnd;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class BlockDndMarkerWidget extends Composite {

	private SimplePanel panel;
	private boolean active;

	public BlockDndMarkerWidget() {
		panel = new SimplePanel();
		panel.setHeight("1px");
		panel.setStyleName("BlockDndMarkerWidget");
		panel.add(new Label(""));

		initWidget(panel);
	}

	public void setActive(boolean active) {
		if (this.active == active) return;
		this.active = active;
		panel.setStyleName(active ? "BlockDndMarkerWidget-active" : "BlockDndMarkerWidget");
	}

}
