package com.example.myfirstapp.modelo

class ItemMesa(val itemMenu: ItemMenu,val cant:Int){

     fun calcularSubtotal(cant: Int):Int {
        val vprecio = itemMenu.precio.toString().toInt()
        val subtotal = vprecio * cant
        return subtotal
    }
}
