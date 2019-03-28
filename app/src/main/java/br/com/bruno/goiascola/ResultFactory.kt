package br.com.bruno.goiascola

class ResultFactory {
    companion object {
        private var instance: ResultFactory? = null
        private lateinit var TYPE_PRODUCT: ProductsEnum
        private var TYPE_BRICK: TijolosEnum? = null
        private var TYPE_REND: RendimentoRebocoEnum? = null
        private var TYPE_REBOC: TipoRebocoEnum? = null

        fun getInstanceFactory(
            typeProducts: ProductsEnum,
            typeBrick: TijolosEnum? = null,
            typeRend: RendimentoRebocoEnum? = null,
            typeReboc: TipoRebocoEnum? = null
        ): ResultFactory{

            if (instance == null){instance = ResultFactory()}

            this.TYPE_PRODUCT = typeProducts
            this.TYPE_BRICK = typeBrick
            this.TYPE_REND = typeRend
            this.TYPE_REBOC = typeReboc

            return instance!!
        }
    }

    fun calcular(mQ: Double): HashMap<Int, String>{
        return when(TYPE_PRODUCT){
            ProductsEnum.ARGAMASSA_POLIMERICA_BARRICA_50KG -> {argamassaPolimericaBarrica50kg(mQ)}
            ProductsEnum.ARGAMASSA_POLIMERICA_SACO_15KG -> {argamassaPolimericaSaco15kg(mQ)}
            ProductsEnum.ARGAMASSA_POLIMERICA_BISNAGA_3KG -> {argamassaPolimericaBisnaga3kg(mQ)}
            ProductsEnum.REBOCO_PLUS_BALDE_30_KG -> {rebocoPlusBalde30kg(mQ)}
            ProductsEnum.REBOCO_PLUS_BARRICA_50_KG -> {rebocoPlusBarrica50kg(mQ)}
            ProductsEnum.CHAPISCO_ROLADO_BARRICA_50KG -> {chapiscoRoladoBarrica50kg(mQ)}
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
            TijolosEnum.TIJOLO_14X09 -> {recipienteEmKg / 2} //recipienteEmKg / M²
            TijolosEnum.TIJOLO_19X09 -> {recipienteEmKg / 1.5}
            TijolosEnum.TIJOLO_DEITADO -> {recipienteEmKg / 2.5}
            TijolosEnum.BLOCO_CONCRETO_19X09 -> {recipienteEmKg / 1.5}
            else -> {recipienteEmKg / 2}
        }
    }

    private fun rebocoPlusBalde30kg(mQ: Double): HashMap<Int, String>{
        val result = HashMap<Int, String>()
        val capacidade = if(TYPE_REBOC == TipoRebocoEnum.ARGAMASSA_POLIMERICA) 10.0 else 6.0
        val r = mQ / capacidade
        if(r <= 1) {
            result[1] = "1 Balde de 30Kg"
        } else {
            val qtd = Math.ceil(r).toInt()
            result[1] = "$qtd Baldes de 30Kg."
            if(qtd > 1) {
                val result2 = rebocoPlusBarrica50kg(mQ)
                result[2] = "É recomendado usar ${result2[1]}"
            }
        }

        return result
    }

    private fun rebocoPlusBarrica50kg(mQ: Double): HashMap<Int, String> {
        val result = HashMap<Int, String>()
        val capacidade = if(TYPE_REBOC == TipoRebocoEnum.ARGAMASSA_POLIMERICA) 16.6 else 10.0
        val r = mQ / capacidade
        if(r <= 1) {
            result[1] = "1 Barrica de 50Kg"
        } else {
            val qtd = Math.ceil(r).toInt()
            result[1] = "$qtd Barricas de 50Kg."
        }

        return result
    }

    private fun chapiscoRoladoBarrica50kg(mQ: Double): HashMap<Int, String>{
        val result = HashMap<Int, String>()

        val r = if(TYPE_REND == RendimentoRebocoEnum.RECEBER_REBOCO) {
            mQ / 50
        } else {
            mQ / 16.6
        }

        if(r <= 1) {
            result[1] = "1 Barrica de 50Kg."
        } else {
            val qtd = Math.ceil(r).toInt()
            result[1] = "$qtd Barricas de 50Kg."
        }

        return result
    }
}