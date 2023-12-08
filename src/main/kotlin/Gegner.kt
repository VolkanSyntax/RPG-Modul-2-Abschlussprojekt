open class Gegner(val name: String, var hp: Int, val maxHp: Int, var isProtected: Boolean = false)  {
    fun takeDamage(damage: Int) {
        if(!isProtected){
            hp = (hp - damage).coerceAtLeast(0)
            println("$name erleidet $damage Schaden. Verbleibende HP: $hp")
        }else{
            println("$name erleidet keinen Schaden wegen dem Schutz")
        }

    }
    fun isAlive(): Boolean = hp > 0

    fun heal(amount: Int) {
        hp = (hp + amount).coerceAtMost(maxHp)
        println("$name heilt sich um $amount. HP: $hp")
    }

    open fun performAction(action: String, target: Held) {
        when (action) {
            "attack" -> target.takeDamage(10) // Basisangriff
            "heal" -> this.heal(15) // Selbstheilung
            else -> println("Diese Action gibt es nicht")
        }
    }

    fun displayInfo() {
        println("$name - HP: $hp")
    }

    override fun toString(): String{
        return """
            Name: $name
            HP: $hp
        """.trimIndent()
    }

}


