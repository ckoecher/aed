package vco.aed.app;

import java.util.HashSet;
import java.util.Set;

import vco.aed.models.Event;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class AddNext extends Activity {

	private Event[] listViewItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_next);
		
		setClickHandlers();
		
		setListViewItems(getAllEvents());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_next, menu);
		return true;
	}

	
	private void setClickHandlers() {
		Button btn = (Button) findViewById(R.id.button1);
		assert (btn != null);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext() ,vco.aed.app.AddLocations.class));
			}
		});
		
	}
	
	private void setListViewItems(Set<Event> events) {
		listViewItems = events.toArray(new Event[events.size()]);
		ListView lv = (ListView) findViewById(R.id.listView1);
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		lv.setAdapter(new ArrayAdapter<Event>(this,android.R.layout.simple_list_item_multiple_choice,listViewItems));				
	}
	
	private Set<Event> getAllEvents() {
		/*alle Events aus der Datenbank laden*/
		/*zum Test: */
		Set<Event> events = new HashSet<Event>();
		events.add(new Event("Event 1"));
		events.add(new Event("Event 2"));
		events.add(new Event("Event 3"));
		events.add(new Event("Event 4"));
		events.add(new Event("Event 5"));
		events.add(new Event("Event 6"));
		events.add(new Event("Event 7"));
		events.add(new Event("Event 8"));
		events.add(new Event("Event 9"));
		events.add(new Event("Event 10"));
		events.add(new Event("Event 11"));
		events.add(new Event("Event 12"));
		events.add(new Event("Event 13"));
		
		return events;
		
	}

}
