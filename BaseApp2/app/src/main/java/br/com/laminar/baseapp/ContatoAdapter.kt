package layout

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.laminar.baseapp.Contato
import br.com.laminar.baseapp.R

class ContatoAdapter (
    private val context: Activity,
    private val arrayList: ArrayList<Contato>
    ) : ArrayAdapter<Contato>(
    context,
    R.layout.listview_contato,
    arrayList,
    ) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val layoutInflater : LayoutInflater = LayoutInflater.from(context)
            val view : View = layoutInflater.inflate(R.layout.listview_contato, null)
            val imgContato = view.findViewById<ImageView>(R.id.iv_contato)
            imgContato.setImageResource(arrayList[position].imagem)
            val tvNomeContato = view.findViewById<TextView>(R.id.tv_nome_contato)
            tvNomeContato.text = arrayList[position].nome
            val tvTelefoneContato = view.findViewById<TextView>(R.id.tv_telefone_contato)
            tvTelefoneContato.text = arrayList[position].telefone
            return view
        }
}