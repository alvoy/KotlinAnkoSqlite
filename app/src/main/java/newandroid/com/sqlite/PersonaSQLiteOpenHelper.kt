package newandroid.com.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import org.jetbrains.anko.db.*

/**
 * Created by Alvaro on 2/28/18.
 */

class PersonaSQLiteOpenHelper(context: Context) : ManagedSQLiteOpenHelper(context, "personas.db", null, 1) {

    companion object {
        private var instance: PersonaSQLiteOpenHelper? = null

        @Synchronized
        fun getInstance(context: Context): PersonaSQLiteOpenHelper {
            if (instance == null) {
                instance = PersonaSQLiteOpenHelper(context.applicationContext)
            }
            return instance!!
        }

    }
    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(PersonaTabla.NOMBRE_TABLA,true,
                PersonaTabla.ID to INTEGER + PRIMARY_KEY,
                PersonaTabla.NOMBRE to TEXT,
                PersonaTabla.APELLIDO to TEXT,
                PersonaTabla.ID_DEP to INTEGER)
        Log.i("LOGTAG", "Tabla creada personas")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(PersonaTabla.NOMBRE_TABLA, true)
        onCreate(db)

    }

}

val Context.database: PersonaSQLiteOpenHelper
    get() = PersonaSQLiteOpenHelper.getInstance(applicationContext)



