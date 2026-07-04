/**
 * Class 1: Produk
 * Mengelola data barang di Aplikasi Kasir. Atribut harga dan stok dilindungi 
 * agar tidak bisa diisi dengan nilai minus atau tidak valid.
 */
class Produk(
    val nama: String,
    hargaAwal: Double,
    stokAwal: Int
) {
    // Custom Setter untuk menjaga harga agar selalu di atas Rp0
    var harga: Double = 0.0
        set(value) {
            if (value > 0.0) {
                field = value
            } else {
                println("[ERROR] Gagal: Harga produk '$nama' harus lebih besar dari Rp0!")
            }
        }

    // Custom Setter untuk menjaga stok agar tidak boleh negatif (Kriteria M5)
    var stok: Int = 0
        set(value) {
            if (value >= 0) {
                field = value
            } else {
                println("[ERROR] Gagal: Stok barang '$nama' tidak boleh bernilai negatif!")
            }
        }

    // Inisialisasi awal untuk memvalidasi data saat objek dibuat pertama kali
    init {
        this.harga = hargaAwal
        this.stok = stokAwal
    }

    /**
     * Mengurangi stok barang ketika ada transaksi pembelian
     */
    fun kurangiStok(jumlah: Int): Boolean {
        return if (stok >= jumlah) {
            stok -= jumlah
            true
        } else {
            println("[ERROR] Gagal: Stok '$nama' tidak mencukupi! Sisa stok: $stok")
            false
        }
    }
}

/**
 * Class 2: Transaksi
 * Mengelola pencatatan belanja kasir secara aman dengan enkapsulasi 'private set'.
 */
class Transaksi(
    val idTransaksi: String,
    val tanggal: String
) {
    // totalBayar diproteksi dengan 'private set' agar tidak bisa dimanipulasi dari luar class
    var totalBayar: Double = 0.0
        private set

    private val keranjangBelanja = mutableListOf<String>()

    /**
     * Menambahkan produk belanjaan ke dalam keranjang kasir
     */
    fun tambahProduk(produk: Produk, kuantitas: Int) {
        if (kuantitas <= 0) {
            println("[ERROR] Gagal: Jumlah barang yang dibeli minimal harus 1 pcs!")
            return
        }

        // Proses kurangi stok produk, jika berhasil maka update total belanja
        if (produk.kurangiStok(kuantitas)) {
            val subTotal = produk.harga * kuantitas
            totalBayar += subTotal
            keranjangBelanja.add("- ${produk.nama} x$kuantitas = Rp$subTotal")
            println("[SUKSES] Menambahkan $kuantitas pcs '${produk.nama}' ke keranjang.")
        }
    }

    /**
     * Mencetak struk belanja kasir secara formal
     */
    fun cetakStruk() {
        println("\n=============================================")
        println("             STRUK KASIR VERA                ")
        println("=============================================")
        println("ID Transaksi : $idTransaksi")
        println("Tanggal      : $tanggal")
        println("---------------------------------------------")
        if (keranjangBelanja.isEmpty()) {
            println("(Keranjang Belanja Kosong)")
        } else {
            keranjangBelanja.forEach { item -> println(item) }
        }
        println("---------------------------------------------")
        println("TOTAL BAYAR  : Rp$totalBayar")
        println("STATUS       : LUNAS")
        println("=============================================\n")
    }
}

fun main() {
    println("=== SIMULASI UJI COBA KEAMANAN APLIKASI KASIR ===\n")

    // 1. Mendaftarkan produk kasir baru
    val sabun = Produk("Sabun Mandi", 4500.0, 15)
    val beras = Produk("Beras Premium 5kg", 72000.0, 8)

    // 2. Menguji sistem keamanan kodingan (Validasi Error)
    println("[UJI COBA 1] Mencoba input harga minus:")
    sabun.harga = -2000.0 // Sistem otomatis menolak harga minus

    println("\n[UJI COBA 2] Mencoba input stok minus:")
    beras.stok = -5 // Sistem otomatis menolak stok minus

    // 3. Menjalankan transaksi yang aman
    println("\n[UJI COBA 3] Memulai transaksi kasir...")
    val kasir = Transaksi("TX-KASIR-99", "2026-07-04")
    
    kasir.tambahProduk(sabun, 3) // Berhasil (stok sabun sisa 12)
    kasir.tambahProduk(beras, 2) // Berhasil (stok beras sisa 6)
    
    // Mencoba membeli melebihi batas stok yang tersedia
    kasir.tambahProduk(beras, 10) // Gagal karena stok sisa 6

    // Mencetak hasil struk transaksi kasir
    kasir.cetakStruk()
}
