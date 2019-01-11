package com.example.bhargavipatel.projectfinal3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class mysql extends SQLiteOpenHelper {

	Context cc;
	SQLiteDatabase mydb=null;
	static String dbname="mm.db";
	String dbpath="/data/data/com.example.jd.offlinedata/databases/";
	
	mysql(Context cont)
	{
		super(cont,dbname,null,1);
		cc=cont;
	}
	
	public void checkMydb()
	{
		String mypath=dbpath+dbname;
		try{
		mydb= SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READONLY);
		}
		catch(Exception e){}
		
		if(mydb==null)
		{
			
			this.getReadableDatabase();
			
			try{
			InputStream is=cc.getAssets().open(dbname);
			OutputStream os=new FileOutputStream(mypath);
			
			byte buffer[]=new byte[1024];
			int n=0;
			while((n=is.read(buffer))>0)
			{
				os.write(buffer, 0, n);
			}
			
			is.close();
			os.close();
			mydb.close();
			Toast.makeText(cc, "Database has been created first time", Toast.LENGTH_SHORT).show();
			}
			catch(Exception e)
			{
				Toast.makeText(cc, "Error : Please Close application and reopen it.", Toast.LENGTH_SHORT).show();
			}
		}
		else
		{



			Toast.makeText(cc, "Database already exist", Toast.LENGTH_SHORT).show();



			mydb.close();
		}
		
		
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
