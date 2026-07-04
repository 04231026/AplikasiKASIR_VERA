<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UML Designer & Exporter - Aplikasi Kasir</title>
    <!-- Memuat Tailwind CSS untuk desain antarmuka yang modern -->
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap');
        body {
            font-family: 'Inter', sans-serif;
        }
        @media print {
            body {
                background: white;
                color: black;
            }
            .no-print {
                display: none !important;
            }
            .print-page {
                box-shadow: none !important;
                border: none !important;
                margin: 0 !important;
                padding: 0 !important;
                width: 100% !important;
                max-width: 100% !important;
                page-break-after: always;
            }
        }
    </style>
</head>
<body class="bg-slate-50 text-slate-800 min-h-screen">

    <!-- Header Section (Disembunyikan saat cetak PDF) -->
    <header class="no-print bg-gradient-to-r from-emerald-700 to-teal-800 text-white shadow-md">
        <div class="max-w-5xl mx-auto px-6 py-6 flex flex-col md:flex-row justify-between items-center gap-4">
            <div>
                <span class="bg-emerald-500/30 text-emerald-200 text-xs font-semibold px-2.5 py-1 rounded-full uppercase tracking-wider">Tugas Kelompok (PBL - M5)</span>
                <h1 class="text-2xl font-bold tracking-tight mt-1">UML Designer - Aplikasi Kasir</h1>
                <p class="text-emerald-100 text-sm mt-0.5">Dokumen Arsitektur Teknis & Rancangan Sistem POS Kelompok.</p>
            </div>
            <div class="flex gap-3">
                <button onclick="window.print()" class="bg-gradient-to-r from-emerald-500 to-teal-600 hover:from-emerald-600 hover:to-teal-700 text-white font-semibold px-5 py-2.5 rounded-xl shadow-lg hover:shadow-xl transition-all flex items-center gap-2 transform active:scale-95">
                    <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17 17h2a2 2 0 002-2v-4a2 2 0 00-2-2H5a2 2 0 00-2 2v4a2 2 0 002 2h2m2 4h6a2 2 0 002-2v-4a2 2 0 00-2-2H9a2 2 0 00-2 2v4a2 2 0 002 2zm8-12V5a2 2 0 00-2-2H9a2 2 0 00-2 2v4h10z"></path></svg>
                    Cetak / Simpan PDF
                </button>
            </div>
        </div>
    </header>

    <!-- Konten Dokumen Utama -->
    <main class="max-w-5xl mx-auto px-4 py-8 md:py-12 space-y-10">

        <!-- Petunjuk Penggunaan (No Print) -->
        <div class="no-print bg-emerald-50 border-l-4 border-emerald-500 p-5 rounded-r-xl shadow-sm">
            <h3 class="font-bold text-emerald-800 text-base mb-1">💡 Langkah Mengunduh PDF Tugas Aplikasi Kasir:</h3>
            <ol class="list-decimal list-inside text-sm text-emerald-700 space-y-1.5">
                <li>Klik tombol <strong>"Cetak / Simpan PDF"</strong> di atas atau tekan <kbd class="px-1.5 py-0.5 bg-white border rounded text-xs font-sans">Ctrl + P</kbd>.</li>
                <li>Pada opsi tujuan pencetakan, pilih <strong>"Save as PDF"</strong> atau <strong>"Simpan sebagai PDF"</strong>.</li>
                <li>Ubah ukuran kertas ke <strong>A4</strong>, dan pastikan opsi <strong>"Background graphics"</strong> dicentang agar warna diagram tetap muncul.</li>
                <li>Simpan file dengan nama <code class="bg-emerald-100 px-1 py-0.5 rounded font-mono">UML_AplikasiKasir.pdf</code> lalu unggah ke repositori GitHub kalian!</li>
            </ol>
        </div>

        <!-- Halaman PDF 1: Cover & Use Case Diagram -->
        <section class="print-page bg-white border border-slate-200 shadow-xl rounded-2xl p-8 md:p-12 space-y-8">
            <!-- Header Dokumen Formal -->
            <div class="border-b-2 border-slate-900 pb-5 text-center md:text-left flex flex-col md:flex-row justify-between items-center gap-4">
                <div>
                    <h2 class="text-xl font-extrabold uppercase tracking-wider text-slate-950">Dokumen Arsitektur Teknis</h2>
                    <p class="text-xs font-bold text-emerald-600 uppercase mt-0.5">Sistem Informasi Pengelolaan Aplikasi Kasir (POS)</p>
                </div>
                <div class="text-center md:text-right text-xs text-slate-500">
                    <p>Kode Tugas: <strong>CPMK-4 & CPMK-5</strong></p>
                    <p>Status: <strong>Final Proposal</strong></p>
                </div>
            </div>

            <!-- Identitas Kelompok -->
            <div class="grid grid-cols-1 md:grid-cols-2 gap-4 bg-slate-50 p-5 rounded-xl border border-slate-150 text-sm">
                <div>
                    <p class="text-slate-500 font-medium">Pemilik Repositori / Anggota:</p>
                    <p class="font-bold text-slate-800">Vera (NIM: 04231026)</p>
                </div>
                <div>
                    <p class="text-slate-500 font-medium">Studi Kasus Sistem:</p>
                    <p class="font-bold text-slate-800">Sistem Aplikasi Kasir & Manajemen Stok Toko</p>
                </div>
            </div>

            <!-- Bagian 1: Use Case Diagram -->
            <div class="space-y-4">
                <div class="border-l-4 border-emerald-600 pl-3">
                    <h3 class="text-lg font-bold text-slate-900">1. Use Case Diagram Aplikasi Kasir</h3>
                    <p class="text-xs text-slate-500">Menampilkan interaksi antara Aktor (Kasir & Manajer) terhadap use case penting dalam batas sistem Kasir.</p>
                </div>

                <!-- SVG Diagram Use Case -->
                <div class="border border-slate-200 rounded-xl p-6 bg-slate-50 flex justify-center">
                    <svg viewBox="0 0 800 380" class="w-full max-w-3xl h-auto" xmlns="http://www.w3.org/2000/svg">
                        <rect width="800" height="380" fill="#f8fafc" rx="12" />

                        <!-- System Boundary -->
                        <rect x="220" y="30" width="360" height="320" fill="#ffffff" stroke="#0f172a" stroke-width="2" rx="10" />
                        <text x="400" y="55" fill="#0f172a" font-family="sans-serif" font-size="14" font-weight="extrabold" text-anchor="middle">Sistem Aplikasi Kasir</text>

                        <!-- ACTOR 1: Kasir (Left) -->
                        <g transform="translate(80, 140)">
                            <circle cx="40" cy="40" r="15" fill="#d1fae5" stroke="#059669" stroke-width="2.5"/>
                            <line x1="40" y1="55" x2="40" y2="105" stroke="#059669" stroke-width="2.5"/>
                            <line x1="15" y1="75" x2="65" y2="75" stroke="#059669" stroke-width="2.5"/>
                            <line x1="40" y1="105" x2="20" y2="145" stroke="#059669" stroke-width="2.5"/>
                            <line x1="40" y1="105" x2="60" y2="145" stroke="#059669" stroke-width="2.5"/>
                            <text x="40" y="165" fill="#0f172a" font-family="sans-serif" font-size="12" font-weight="bold" text-anchor="middle">Kasir (Aktor)</text>
                        </g>

                        <!-- ACTOR 2: Manajer (Right) -->
                        <g transform="translate(640, 140)">
                            <circle cx="40" cy="40" r="15" fill="#fef3c7" stroke="#d97706" stroke-width="2.5"/>
                            <line x1="40" y1="55" x2="40" y2="105" stroke="#d97706" stroke-width="2.5"/>
                            <line x1="15" y1="75" x2="65" y2="75" stroke="#d97706" stroke-width="2.5"/>
                            <line x1="40" y1="105" x2="20" y2="145" stroke="#d97706" stroke-width="2.5"/>
                            <line x1="40" y1="105" x2="60" y2="145" stroke="#d97706" stroke-width="2.5"/>
                            <text x="40" y="165" fill="#0f172a" font-family="sans-serif" font-size="12" font-weight="bold" text-anchor="middle">Manajer (Aktor)</text>
                        </g>

                        <!-- Use Cases -->
                        <!-- UC1: Kelola Produk -->
                        <g id="uc-kelola-produk">
                            <ellipse cx="400" cy="110" rx="95" ry="25" fill="#ecfdf5" stroke="#059669" stroke-width="2" />
                            <text x="400" y="114" fill="#065f46" font-family="sans-serif" font-size="11" font-weight="bold" text-anchor="middle">Kelola Data Produk</text>
                        </g>

                        <!-- UC2: Catat Transaksi -->
                        <g id="uc-catat-transaksi">
                            <ellipse cx="400" cy="190" rx="95" ry="25" fill="#ecfdf5" stroke="#059669" stroke-width="2" />
                            <text x="400" y="194" fill="#065f46" font-family="sans-serif" font-size="11" font-weight="bold" text-anchor="middle">Catat Transaksi Kasir</text>
                        </g>

                        <!-- UC3: Laporan Keuangan -->
                        <g id="uc-laporan">
                            <ellipse cx="400" cy="270" rx="95" ry="25" fill="#fffbeb" stroke="#d97706" stroke-width="2" />
                            <text x="400" y="274" fill="#92400e" font-family="sans-serif" font-size="11" font-weight="bold" text-anchor="middle">Lihat Laporan Penjualan</text>
                        </g>

                        <!-- Hubungan Garis (Links) -->
                        <!-- Kasir -> Catat Transaksi -->
                        <line x1="150" y1="215" x2="305" y2="190" stroke="#059669" stroke-width="1.5" stroke-dasharray="0" />
                        
                        <!-- Manajer -> Kelola Produk -->
                        <line x1="650" y1="210" x2="495" y2="110" stroke="#d97706" stroke-width="1.5" />
                        
                        <!-- Manajer -> Laporan -->
                        <line x1="650" y1="215" x2="495" y2="270" stroke="#d97706" stroke-width="1.5" />
                    </svg>
                </div>
            </div>
        </section>

        <!-- Halaman PDF 2: Class Diagram -->
        <section class="print-page bg-white border border-slate-200 shadow-xl rounded-2xl p-8 md:p-12 space-y-8">
            <div class="space-y-4">
                <div class="border-l-4 border-emerald-600 pl-3">
                    <h3 class="text-lg font-bold text-slate-900">2. Class Diagram Utama Aplikasi Kasir</h3>
                    <p class="text-xs text-slate-500">Model hubungan relasional data entitas Pengguna, Produk, dan transaksi.</p>
                </div>

                <!-- SVG Diagram Class -->
                <div class="border border-slate-200 rounded-xl p-6 bg-slate-50 flex justify-center">
                    <svg viewBox="0 0 800 450" class="w-full max-w-3xl h-auto" xmlns="http://www.w3.org/2000/svg">
                        <rect width="800" height="450" fill="#f8fafc" rx="12" />

                        <!-- CLASS 1: Pengguna (Top Left) -->
                        <g transform="translate(40, 40)">
                            <rect width="210" height="35" fill="#ecfdf5" stroke="#059669" stroke-width="2" rx="6"/>
                            <text x="105" y="22" fill="#065f46" font-family="sans-serif" font-size="12" font-weight="bold" text-anchor="middle">Pengguna</text>
                            
                            <rect y="35" width="210" height="75" fill="#ffffff" stroke="#059669" stroke-width="2" />
                            <text x="10" y="55" fill="#334155" font-family="monospace" font-size="11">+ nama: String</text>
                            <text x="10" y="75" fill="#334155" font-family="monospace" font-size="11">- role: String</text>
                            <text x="10" y="95" fill="#334155" font-family="monospace" font-size="11">- pin: String</text>
                            
                            <rect y="110" width="210" height="50" fill="#ffffff" stroke="#059669" stroke-width="2" rx="6" />
                            <text x="10" y="130" fill="#1e293b" font-family="monospace" font-size="11">+ login(): Boolean</text>
                            <text x="10" y="148" fill="#1e293b" font-family="monospace" font-size="11">+ updateProfile(): Void</text>
                        </g>

                        <!-- CLASS 2: Produk (Top Right) -->
                        <g transform="translate(540, 40)">
                            <rect width="220" height="35" fill="#ecfdf5" stroke="#059669" stroke-width="2" rx="6"/>
                            <text x="110" y="22" fill="#065f46" font-family="sans-serif" font-size="12" font-weight="bold" text-anchor="middle">Produk</text>
                            
                            <rect y="35" width="220" height="95" fill="#ffffff" stroke="#059669" stroke-width="2" />
                            <text x="10" y="55" fill="#334155" font-family="monospace" font-size="11">+ nama: String</text>
                            <text x="10" y="75" fill="#334155" font-family="monospace" font-size="11">- harga: Double</text>
                            <text x="10" y="95" fill="#334155" font-family="monospace" font-size="11">- stok: Int</text>
                            <text x="10" y="115" fill="#334155" font-family="monospace" font-size="11">+ isTersedia: Boolean</text>
                            
                            <rect y="130" width="220" height="55" fill="#ffffff" stroke="#059669" stroke-width="2" rx="6" />
                            <text x="10" y="150" fill="#1e293b" font-family="monospace" font-size="11">+ updateStok(qty: Int)</text>
                            <text x="10" y="170" fill="#1e293b" font-family="monospace" font-size="11">+ cekStok(): Int</text>
                        </g>

                        <!-- CLASS 3: Transaksi (Bottom Center) -->
                        <g transform="translate(280, 250)">
                            <rect width="240" height="35" fill="#fffbeb" stroke="#d97706" stroke-width="2" rx="6"/>
                            <text x="120" y="22" fill="#92400e" font-family="sans-serif" font-size="12" font-weight="bold" text-anchor="middle">Transaksi</text>
                            
                            <rect y="35" width="240" height="75" fill="#ffffff" stroke="#d97706" stroke-width="2" />
                            <text x="10" y="55" fill="#334155" font-family="monospace" font-size="11">+ idTransaksi: String</text>
                            <text x="10" y="75" fill="#334155" font-family="monospace" font-size="11">+ tanggal: Date</text>
                            <text x="10" y="95" fill="#334155" font-family="monospace" font-size="11">- totalBayar: Double</text>
                            
                            <rect y="110" width="240" height="50" fill="#ffffff" stroke="#d97706" stroke-width="2" rx="6" />
                            <text x="10" y="130" fill="#1e293b" font-family="monospace" font-size="11">+ hitungBiaya(): Double</text>
                            <text x="10" y="148" fill="#1e293b" font-family="monospace" font-size="11">+ cetakStruk(): Void</text>
                        </g>

                        <!-- Connections (Relasi) -->
                        <!-- Pengguna (1) --- melakukan --- (0..*) Transaksi -->
                        <path d="M 145 200 L 145 320 L 280 320" fill="none" stroke="#475569" stroke-width="2" />
                        <polygon points="280,320 270,315 270,325" fill="#475569" />
                        <text x="155" y="215" fill="#475569" font-family="sans-serif" font-size="11">1</text>
                        <text x="260" y="312" fill="#475569" font-family="sans-serif" font-size="11">0..*</text>
                        <text x="155" y="260" fill="#475569" font-family="sans-serif" font-size="11" font-weight="bold">melakukan</text>

                        <!-- Transaksi (0..*) --- berisi --- (1..*) Produk -->
                        <path d="M 520 320 L 650 320 L 650 225" fill="none" stroke="#475569" stroke-width="2" />
                        <polygon points="650,225 645,235 655,235" fill="#475569" />
                        <text x="535" y="312" fill="#475569" font-family="sans-serif" font-size="11">0..*</text>
                        <text x="660" y="240" fill="#475569" font-family="sans-serif" font-size="11">1..*</text>
                        <text x="575" y="340" fill="#475569" font-family="sans-serif" font-size="11" font-weight="bold">berisi</text>
                    </svg>
                </div>
            </div>

            <!-- Catatan Teknis Enkapsulasi -->
            <div class="mt-4 bg-slate-50 p-5 rounded-xl border border-slate-200 text-sm space-y-2">
                <h4 class="font-bold text-emerald-800 flex items-center gap-1.5">
                    <svg class="w-4 h-4" fill="currentColor" viewBox="0 0 20 20"><path fill-rule="evenodd" d="M5 9V7a5 5 0 0110 0v2a2 2 0 012 2v5a2 2 0 01-2 2H5a2 2 0 01-2-2v-5a2 2 0 012-2zm8-2v2H7V7a3 3 0 016 0z" clip-rule="evenodd"></path></svg>
                    Penerapan Proteksi & Enkapsulasi Kasir:
                </h4>
                <ul class="list-disc list-inside text-slate-600 space-y-1">
                    <li>Atribut bertanda minus (<code class="bg-slate-200 px-1 rounded font-mono font-bold text-red-600">-</code>) memiliki sifat <strong>Private</strong>.</li>
                    <li>Sesuai instruksi gambar, <code class="font-mono text-xs">harga</code> dan <code class="font-mono text-xs">stok</code> dilindungi sepenuhnya agar tidak bernilai negatif melalui fungsi validasi khusus.</li>
                    <li>Atribut keuangan <code class="font-mono text-xs">totalBayar</code> pada transaksi disembunyikan menggunakan pelindung <code class="font-mono text-xs">private set</code> demi menjamin keaslian pencatatan keuangan.</li>
                </ul>
            </div>
        </section>
    </main>

    <!-- Footer Dokumen -->
    <footer class="no-print text-center py-8 text-xs text-slate-400 border-t border-slate-200 mt-12 bg-white">
        <p>&copy; 2026 Aplikasi Kasir Team. Seluruh diagram dibuat secara dinamis untuk tugas kelompok CPMK-4 & CPMK-5.</p>
    </footer>

</body>
</html>
