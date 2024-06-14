class MenuKopi(val nama: String, val harga: Int)

class PenjualanKopi {
    val menuKopi = listOf(
        MenuKopi("Espresso", 15000),
        MenuKopi("Americano", 18000),
        MenuKopi("Cappuccino", 20000),
        MenuKopi("Latte", 22000)
    )

    fun tampilkanMenu() {
        println("=========================")
        println("Menu Kopi:")
        menuKopi.forEachIndexed { index, item ->
            println("${index + 1}. ${item.nama} - Rp${item.harga}")
        }
        println("=========================\n")
    }

    fun pesanKopi(pilihan: Int, jumlah: Int): Int {
        if (pilihan in 1..menuKopi.size) {
            val totalHarga = menuKopi[pilihan - 1].harga * jumlah
            println("Anda memesan ${menuKopi[pilihan - 1].nama} sebanyak $jumlah, total harga: Rp$totalHarga")
            return totalHarga
        } else {
            println("Pilihan tidak valid.")
            return 0
        }
    }
}

fun main() {
    val penjualan = PenjualanKopi()
    var totalBelanja = 0

    println("Selamat datang di Warung Kopi ABC \n")

    do {
        penjualan.tampilkanMenu()
        val pilihan = readLine()?.toIntOrNull() ?: 2
        if (pilihan !in 1..penjualan.menuKopi.size) {
            println("Pilihan tidak valid.")
            continue
        }

        print("Jumlah pesanan: ")
        val jumlah = readLine()?.toIntOrNull() ?: 2
        if (jumlah <= 0) {
            println("Jumlah pesanan tidak valid.")
            continue
        }

        totalBelanja += penjualan.pesanKopi(pilihan, jumlah)
	
    } while (readLine()?.equals("ya", ignoreCase = true) == true)

    println("Terima kasih telah memesan di Warung Kopi ABC")
    println("Total belanja Anda: Rp$totalBelanja")
}