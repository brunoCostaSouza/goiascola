package br.com.bruno.goiascola

class ResultFactory {
    companion object {
        private var instance: ResultFactory? = null
        private lateinit var TYPE_PRODUCT: ProductsEnum
        private var TYPE_BRICK: TijolosEnum? = null

        fun getInstanceFactory(typeProducts: ProductsEnum, typeBrick: TijolosEnum? = null): ResultFactory{
            if (instance == null){
                instance = ResultFactory()
            }
            this.TYPE_PRODUCT = typeProducts
            this.TYPE_BRICK = typeBrick

            return instance!!
        }
    }

    fun calcular(mQ: Double): HashMap<Int, String>{
        return when(TYPE_PRODUCT){
            ProductsEnum.ARGAMASSA_POLIMERICA_BARRICA_50KG -> {argamassaPolimericaBarrica50kg(mQ)}
            ProductsEnum.ARGAMASSA_POLIMERICA_SACO_15KG -> {argamassaPolimericaSaco15kg(mQ)}
            ProductsEnum.ARGAMASSA_POLIMERICA_BISNAGA_3KG -> {argamassaPolimericaBisnaga3kg(mQ)}
            ProductsEnum.REBOCO_PLUS_BALDE_30_KG -> {rebocoPlusBalde30kg(mQ)}
            ProductsEnum.CHAPISCO_ROLADO_BARRICA_40KG -> {chapiscoRoladoBarrica40kg(mQ)}
        }
    }

    private fun argamassaPolimericaBarrica50kg(mQ: Double): HashMap<Int, String> {
        val result = HashMap<Int, String>()
        val r = mQ / capacidade(50.0)
        if(r <= 1){
            result[1] = "1 Barrica de 50Kg."
        } else {
            val qtd = Math.ceil(r).toInt()
            result[1] = "$qtd Barricas de 50Kg."
        }
        return result
    }

    private fun argamassaPolimericaSaco15kg(mQ: Double): HashMap<Int, String>{
        val result = HashMap<Int, String>()
        val r = mQ / capacidade(15.0)
        if(r <= 1){
            result[1] = "1 saco valvulado de 15Kg."
        } else {
            val qtd = Math.ceil(r).toInt()
            result[1] = "$qtd sacos valvulados de 15Kg."

            if(qtd > 3){
                val result2 = argamassaPolimericaBarrica50kg(mQ)
                if(result2.size > 0){
                    result[2] = "É recomendado usar ${result2[1]}"
                }
            }
        }

        return result
    }

    private fun argamassaPolimericaBisnaga3kg(mQ: Double): HashMap<Int, String>{
        val result = HashMap<Int, String>()

        val r = mQ / capacidade(3.5)
        if(r <= 1){
            result[1] = "1 bisnaga de 3,5Kg."
        } else {
            val qtd = Math.ceil(r).toInt()
            result[1] = "$qtd bisnagas de 3,5Kg."
            if(qtd >= 5){
                val result2 = argamassaPolimericaSaco15kg(mQ)
                if(result2.size > 1){
                    result[2] = "${result2[2]}"
                } else {
                    result[2] = "É recomendado usar ${result2[1]}"
                }
            }
        }

        return result
    }

    private fun capacidade(recipienteEmKg: Double): Double{
        return  when(TYPE_BRICK){
            TijolosEnum.TIJOLO_14X09 -> {recipienteEmKg / 2}
            TijolosEnum.TIJOLO_19X09 -> {recipienteEmKg / 1.5}
            TijolosEnum.TIJOLO_DEITADO -> {recipienteEmKg / 2.5}
            TijolosEnum.BLOCO_CONCRETO_19X09 -> {recipienteEmKg / 1.5}
            else -> {recipienteEmKg / 2}
        }
    }

    private fun rebocoPlusBalde30kg(mQ: Double): HashMap<Int, String>{
        val result = HashMap<Int, String>()
        val r = mQ / 10
        if(r <= 1) {
            result[1] = "1 Balde de 30Kg"
        } else {
            val qtd = Math.ceil(r).toInt()
            result[1] = "$qtd Baldes de 30Kg."
        }

        return result
    }

    private fun chapiscoRoladoBarrica40kg(mQ: Double): HashMap<Int, String>{
        val result = HashMap<Int, String>()
        val r = mQ / 40
        if(r <= 1) {
            result[1] = "1 Barrica de 40Kg."
        } else {
            val qtd = Math.ceil(r).toInt()
            result[1] = "$qtd Barricas de 40Kg."
        }

        return result
    }
}