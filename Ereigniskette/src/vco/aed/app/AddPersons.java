package vco.aed.app;

import java.util.HashSet;
import java.util.Set;

import vco.aed.models.Person;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class AddPersons extends Activity {

	private Person[] listViewItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_persons);
		
		setClickHandlers();
		
		setListViewItems(getAllPersons());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_persons, menu);
		return true;
	}
	
	private void setClickHandlers() {
		Button newPersonBtn = (Button) findViewById(R.id.button1);
		assert (newPersonBtn != null);
		newPersonBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext() ,vco.aed.app.NewPerson.class));
			}
		});
		
		Button addLocationsBtn = (Button) findViewById(R.id.button2);
		assert (addLocationsBtn != null);
		addLocationsBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext() ,vco.aed.app.EventDetails.class));
			}
		});
	}
	
	private void setListViewItems(Set<Person> persons) {
		listViewItems = persons.toArray(new Person[persons.size()]);
		ListView lv = (ListView) findViewById(R.id.listView1);
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		lv.setAdapter(new ArrayAdapter<Person>(this,android.R.layout.simple_list_item_multiple_choice,listViewItems));				
	}
	
	private Set<Person> getAllPersons() {
		/*alle Personen aus der Datenbank laden*/
		/*zum Test: */
		Set<Person> persons = new HashSet<Person>();
		persons.add(new Person("Person 1"));
		persons.add(new Person("Person 2"));
		persons.add(new Person("Person 3"));
		persons.add(new Person("Person 4"));
		persons.add(new Person("Person 5"));
		persons.add(new Person("Person 6"));
		persons.add(new Person("Person 7"));
		persons.add(new Person("Person 8"));
		persons.add(new Person("Person 9"));
		
		return persons;
	}

}
