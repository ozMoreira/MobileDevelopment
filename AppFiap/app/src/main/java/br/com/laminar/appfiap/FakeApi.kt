package br.com.laminar.appfiap

class FakeApi {
    fun getEstados(): Array<String>{
        return arrayOf(
            "Acre",
            "Alagoas",
            "Amazonas",
            "Bahia",
            "Ceará",
            "Distrito Federal",
            "Espírito Santo",
            "Goiás",
            "Maranhão",
            "Mato Grosso",
            "Mato Grosso do Sul",
            "Minas Gerais",
            "Pará",
            "Paraíba",
            "Paraná",
            "Pernambuco",
            "Piauí",
            "Rio de Janeiro",
            "Rio Grande do Norte",
            "Rio Grande do Sul",
            "Rondônia",
            "Roraima",
            "Santa Catarina",
            "São Paulo",
            "Sergipe",
            "Tocantins",

        )
    }

    fun getContatos(): ArrayList<Contato>{
        val contatoList = ArrayList<Contato>()

        for (i in 1..10){
            val contato = Contato(
                1,
                "Joao "+ i.toString(),
                "11 9999-"+ i.toString()+ i.toString()+ i.toString()+ i.toString(),
                R.drawable.avatar,
                "Bla bla bla "+ i.toString(),
            )
            contatoList.add(contato)
        }
        return contatoList
    }
}