package vco.aed.app;

import java.util.HashSet;
import java.util.Set;

import vco.aed.models.Location;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class AddLocations extends Activity {

	private Location[] listViewItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_location);
		
		setClickHandlers();
		
		setListViewItems(getAllLocations());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_location, menu);
		return true;
	}
	
	private void setClickHandlers() {
		Button newLocationBtn = (Button) findViewById(R.id.button1);
		assert (newLocationBtn != null);
		newLocationBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext() ,vco.aed.app.NewLocation.class));
			}
		});
		
		Button saveBtn = (Button) findViewById(R.id.button2);
		assert (saveBtn != null);
		saveBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext() ,vco.aed.app.AddPersons.class));
			}
		});
	}
	
	private void setListViewItems(Set<Location> locations) {
		listViewItems = locations.toArray(new Location[locations.size()]);
		ListView lv = (ListView) findViewById(R.id.listView1);
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		lv.setAdapter(new ArrayAdapter<Location>(this,android.R.layout.simple_list_item_multiple_choice,listViewItems));				
	}
	
	private Set<Location> getAllLocations() {
		/*alle Orte aus der Datenbank laden*/
		/*zum Test: */
		Set<Location> locations = new HashSet<Location>();
		locations.add(new Location("Location 1"));
		locations.add(new Location("Location 2"));
		locations.add(new Location("Location 3"));
		locations.add(new Location("Location 4"));
		locations.add(new Location("Location 5"));
		locations.add(new Location("Location 6"));
		
		return locations;
	}

}
