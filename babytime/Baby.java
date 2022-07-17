package project.babytime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Baby extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baby);
        
        Button add = (Button) findViewById(R.id.addBaby);
        add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent addBaby = new Intent(Baby.this,AddBaby.class);
				startActivity(addBaby);
			}
		});
        
        Button show = (Button) findViewById(R.id.showBaby);
        show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent show = new Intent(Baby.this,babyList.class);
				startActivity(show);
			}
		});

    }
    
}
