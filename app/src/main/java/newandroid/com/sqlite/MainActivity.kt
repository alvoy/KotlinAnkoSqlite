package newandroid.com.sqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import org.jetbrains.anko.db.*



 class MainActivity : AppCompatActivity() {

      lateinit var inserta: Button
      lateinit var join: Button
      lateinit var personas: List<Persona>
      lateinit var departamentos: List<Departamento>
      lateinit var dataSource: DataSource
      lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inserta = findViewById(R.id.button) as Button
        join = findViewById(R.id.button2) as Button
        recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        dataSource = DataSource(this)
        createData()

        inserta.setOnClickListener {
            personas = dataSource.getPersonas()
            departamentos = dataSource.getDepartamentos()
            recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
            recyclerView.adapter = MyAdapter(personas)
        }

        join.setOnClickListener {

            //departamentos = dataSource.queryJoin();
        }

    }

    fun createData() {
        dataSource.create()
        dataSource.getPersonas()


    }



}
