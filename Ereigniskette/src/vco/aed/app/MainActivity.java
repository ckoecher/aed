package vco.aed.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setClickHandlers();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void setClickHandlers() {
		Button showEventBtn = (Button) findViewById(R.id.button1);
		assert (showEventBtn != null);
		showEventBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext() ,vco.aed.app.ChooseEvent.class));
			}
		});
		
		Button newEventBtn = (Button) findViewById(R.id.button2);
		assert (newEventBtn != null);
		newEventBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext() ,vco.aed.app.NewEvent.class));
			}
		});
	}
	
	

}
