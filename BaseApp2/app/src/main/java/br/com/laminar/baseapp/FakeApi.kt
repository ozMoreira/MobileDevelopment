package br.com.laminar.baseapp

class FakeApi {

    fun getEstados(): Array<String>{
        return arrayOf(
            "Acre",
            "Alagoas",
            "Amapa",
            "Amazonas"
        )
    }

    fun getContatos(): ArrayList<Contato> {
        val contatoList = ArrayList<Contato>()
        for (i in 1..10) {
            val contato = Contato(
                i,
                "Nome " + i.toString(),
                "telefone " + i.toString(),
                R.drawable.avatar,
                "sobre" + i.toString(),
            )
            contatoList.add(contato)
        }
        return contatoList
    }
}