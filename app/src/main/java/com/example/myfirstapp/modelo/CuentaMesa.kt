package com.example.myfirstapp.modelo

class CuentaMesa(val items: MutableList<ItemMesa> = mutableListOf<ItemMesa>()) {

    var aceptaPropina: Boolean = true
    fun agregarItem(itemMenu: ItemMenu, cantidad:Int){

    }
    fun agregarItem(itemMesa: ItemMesa){
        items.add(itemMesa)
    }
    fun calcularTotalSinPropina():Int{
        return 1
    }
    fun calcularPropina():Int{
        return 2
    }
    fun calcularTotalConPropina():Int{
        return 3
    }
}


