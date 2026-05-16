LATIHAN RESPONSI PRAKTIKUM PEMROGRAMAN BERORIENTASI OBJEK IF-A 
"Sistem Manajemen Perpustakaan" 

Deskripsi 
Rina adalah seorang pustakawan di sebuah perpustakaan kota yang sibuk. Setiap harinya, 
ia harus mencatat data buku, memproses peminjaman, serta melacak pengembalian buku 
secara manual menggunakan buku catatan. Hal ini seringkali menyebabkan kesalahan 
pencatatan dan lambatnya pelayanan. Melihat kondisi tersebut, Rina membutuhkan sebuah 
sistem berbasis desktop yang dapat membantu pengelolaan data perpustakaan secara lebih 
efisien. 

Anda diminta untuk membantu Rina dengan membuat program Sistem Manajemen 
Perpustakaan menggunakan Java. Program ini harus dibangun menggunakan pendekatan 
berorientasi objek, memiliki antarmuka grafis (GUI), data disimpan ke dalam database 
MySQL, serta menggunakan file JAR eksternal sebagai MySQL Connector untuk 
menghubungkan program dengan database. 

Rincian Program 
Program yang akan dibuat memuat beberapa fitur di dalamnya. Berikut rincian untuk setiap 
fitur yang ada pada program ini: 
1. Login dan Register 
Ketika pertama kali program dijalankan, user akan dihadapkan pada halaman Login. 
Apabila belum memiliki akun, user dapat berpindah ke halaman Register untuk membuat 
akun baru. Data akun disimpan ke dalam database MySQL. Ketentuan fitur ini adalah 
sebagai berikut: 
    • Halaman Login menampilkan field username dan password. User hanya dapat 
    masuk apabila kombinasi username dan password yang diinput sesuai dengan data 
    yang tersimpan di database. 
    • Kesempatan login dibatasi sebanyak 3 kali. Apabila user gagal login sebanyak 3 
    kali berturut-turut, program akan menampilkan pesan peringatan dan menutup diri 
    secara otomatis. 
    • Halaman Register menampilkan field nama lengkap, username, dan password. 
    Pastikan username bersifat unik — berikan pesan error apabila username yang 
    didaftarkan sudah ada di database. 
    • Setelah register berhasil, user diarahkan kembali ke halaman Login untuk 
    melakukan autentikasi. 
    • Setelah login berhasil, user diarahkan ke halaman utama program. 

2. Struktur Data dan Desain Kelas 
Program harus memiliki hierarki kelas yang merepresentasikan entitas pada perpustakaan. 
Ketentuan kelas yang harus dibuat adalah sebagai berikut: 
    • Buat kelas abstrak ItemPerpustakaan yang memiliki atribut id, judul, dan 
    tahunTerbit sebagai atribut yang diwarisi oleh kelas turunannya. 
    • Buat kelas Buku dan kelas Majalah yang mewarisi kelas ItemPerpustakaan. 
    Kelas Buku memiliki atribut tambahan pengarang dan ISBN, sedangkan kelas 
    Majalah memiliki atribut tambahan edisi dan penerbit. 
    • Buat interface Pinjamable yang memiliki method pinjam() dan kembalikan() 
    untuk diimplementasikan oleh kelas yang membutuhkan fitur peminjaman. 
    • Terapkan enkapsulasi pada seluruh atribut kelas dengan menggunakan access 
    modifier yang sesuai serta menyediakan getter dan setter. 

3. Antarmuka Grafis (GUI) 
Program harus memiliki antarmuka grafis yang intuitif menggunakan Java Swing. 
Tampilan yang harus dibuat antara lain: 
    • Halaman utama berupa JFrame yang menampilkan tabel data seluruh item 
    perpustakaan (Buku dan Majalah) yang tersedia. 
    • Tombol-tombol aksi (Tambah, Edit, Hapus, Cari) yang dapat diakses melalui 
    halaman utama. 
    • Dialog form terpisah untuk proses tambah dan edit data, dengan validasi input 
    yang sesuai (tidak boleh ada field yang kosong). 
    • Pastikan setiap interaksi pengguna (klik tombol, input form) ditangani 
    menggunakan event handling yang tepat. 

4. Fitur CRUD Data Buku dan Majalah 
Program harus mendukung operasi CRUD (Create, Read, Update, Delete) secara penuh 
terhadap data item perpustakaan yang tersimpan di database MySQL. Ketentuan tiap 
operasi adalah sebagai berikut: 
    • Tambah (Create): User dapat menambahkan data Buku atau Majalah baru melalui 
    form dialog. ID item di-generate secara otomatis oleh sistem. 
    • Tampil (Read): Seluruh data item perpustakaan diambil dari database dan 
    ditampilkan dalam bentuk tabel pada halaman utama. 
    • Edit (Update): User dapat mengubah data item yang sudah ada dengan memilih 
    baris pada tabel, lalu menekan tombol Edit. 
    • Hapus (Delete): User dapat menghapus data item dengan memilih baris pada tabel 
    dan menekan tombol Hapus. Berikan dialog konfirmasi sebelum penghapusan 
    dilakukan. 

5. Arsitektur MVC (Model-View-Controller) 
Program harus dibangun menggunakan pola arsitektur MVC. Pembagian tanggung jawab 
tiap lapisan adalah sebagai berikut: 
    • Model: Berisi kelas-kelas entitas (ItemPerpustakaan, Buku, Majalah) serta kelas 
    yang bertanggung jawab atas komunikasi dengan database MySQL (query 
    INSERT, SELECT, UPDATE, DELETE). 
    • View: Berisi seluruh komponen antarmuka grafis (JFrame, JPanel, JDialog, dan 
    komponen Swing lainnya). 
    • Controller: Berisi logika yang menghubungkan View dan Model, termasuk 
    penanganan event dari user dan pembaruan tampilan. 
