package project.babytime;

import java.io.IOException;

import util.DbHelper;
import android.app.Activity;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddBaby extends Activity {

	String name;
	String family;
	String birthDay;
	String code;
	String bloodGroup;
	String bime;
	String special;
	String fatherName;
	String motherName;
	String telNumber;

	static int n = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_baby);

		Button save = (Button) findViewById(R.id.save);
		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				EditText n1 = (EditText) findViewById(R.id.name);
				name = n1.getText().toString();
				EditText n2 = (EditText) findViewById(R.id.family);
				family = n2.getText().toString();
				EditText n3 = (EditText) findViewById(R.id.birthday);
				birthDay = n3.getText().toString();
				EditText n4 = (EditText) findViewById(R.id.code);
				code = n4.getText().toString();
				EditText n5 = (EditText) findViewById(R.id.bloodGroup);
				bloodGroup = n5.getText().toString();
				EditText n6 = (EditText) findViewById(R.id.bime);
				bime = n6.getText().toString();
				EditText n7 = (EditText) findViewById(R.id.special);
				special = n7.getText().toString();
				EditText n8 = (EditText) findViewById(R.id.fatherName);
				fatherName = n8.getText().toString();
				EditText n9 = (EditText) findViewById(R.id.motherName);
				motherName = n9.getText().toString();
				EditText n10 = (EditText) findViewById(R.id.telNumber);
				telNumber = n10.getText().toString();

				Insert(name, family, birthDay, code, bloodGroup, bime, special,
						fatherName, motherName, telNumber);

				TextView tv = (TextView) findViewById(R.id.Message);
				tv.setText("baby inserted");
			}
		});

	}

	void Insert(String name, String family, String birthDay, String code,
			String bloodGroup, String bime, String special, String fatherName,
			String motherName, String telNumber) {

		DbHelper mDbHelper = new DbHelper(this);
		SQLiteDatabase mDb = null;
		try {
			mDbHelper.createDataBase();
			mDbHelper.openDataBase();
			mDbHelper.close();
			mDb = mDbHelper.getReadableDatabase();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			String sql = "insert into baby (name,family,birthDay,code,bloodGroup,bime,special,fatherName,motherName,telNumber) values ('"
					+ name
					+ "' , '"
					+ family
					+ "' , '"
					+ birthDay
					+ "' , '"
					+ code
					+ "' , '"
					+ bloodGroup
					+ "' , '"
					+ bime
					+ "' , '"
					+ special
					+ "' , '"
					+ fatherName
					+ "' , '"
					+ motherName
					+ "' , '" + telNumber + "')";

			mDb.execSQL(sql);
			mDb.close();

		} catch (SQLException mSQLException) {
			throw mSQLException;
		}
	}

}
