package newandroid.com.sqlite

/**
 * Created by Alvaro on 3/7/18.
 */
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.persona_adapter.view.*

class MyAdapter (val personas: List<Persona>):
                 RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.persona_adapter, parent, false)
        Log.i("SIZE",personas.size.toString())
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(personas[position])
    }

    override fun getItemCount(): Int {
        return personas.size
    }


     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



         fun bindItems(persona: Persona) {

                itemView.nombre.text = persona.nombre
                itemView.apellido_persona.text = persona.apellido
                Log.i("NOMBRE", itemView.nombre.text.toString())

        }

    }
}

