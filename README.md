<h1>Clash Lite</h1>
<div align="Justify">
Aplikasi game sederhana berbasis konsol yang mensimulasikan pembangunan desa, pengelolaan sumber daya (gold dan elixir), rekrutmen pasukan, serta pertempuran untuk mendapatkan sumber daya melimpah.
</div>

<h3>Penjelasan Game</h3>
<div align="Justify">
Game Clash Lite adalah sistem simulasi strategi sederhana yang dirancang untuk memberikan pengalaman membangun dan mengelola sebuah desa. 
Pemain dapat meng-upgrade bangunan seperti Town Hall, Barracks, dan Army Camp, merekrut pasukan (Barbarian, Archer), serta melakukan serangan untuk memperoleh gold dan elixir tambahan.
</div>

<h3>Fitur utama meliputi:</h3>
<ol>
  <li>Memasukkan nama untuk memulai permainan</li>
  <li>Menampilkan sistem dan status desa dengan bangunan utama (Town Hall, Barracks, Army Camp)</li>
  <li>Mekanisme upgrade bangunan sesuai level Town Hall</li>
  <li>Rekrutmen pasukan menggunakan elixir dan kapasitas Army Camp</li>
  <li>Manajemen pasukan dalam Army Camp sebelum menyerang</li>
  <li>Sistem pertarungan (Attack) untuk mendapatkan gold dan elixir</li>
</ol>

Struktur package dan class:
<pre>Clash Lite
├── app
│ └── Main.java 
├── exception
│ └── GameException.java
├── model
│ ├── Army.java 
│ └── Armycamp.java
│ └── Barracks.java
│ └── Building.java
│ └── Player.java
│ └── TownHall.java
│ └── Troop.java
│ └── Village.java
└── service
  └── GameService.java 
</pre>
<h3>Contoh Penggunaan Fitur Utama</h3>
<h4>1. Memasukkan nama player</h4>
- Pemain diminta untuk menginput nama untuk memulai permainan <br><br>
<img width="280" height="35" alt="image" src="https://github.com/user-attachments/assets/1c17b6ca-cca7-4be4-b350-753a8d2e15f3" />

<h4>2. Menampilkan status desa dan kesediaan sumber daya</h4>
- Menampilkan keadaan desa dengan bangunan utama (Town Hall, Barracks, Army Camp), dan banyaknya sumber daya yang ada <br><br>
<img width="234" height="280" alt="image" src="https://github.com/user-attachments/assets/efafe21b-f3e2-4f80-b17c-984267b42eef" />

<h4>3. Meningkatkan bangunan yang ada di dalam desa</h4>
- Terdapat 3 bangunan (Town Hall, Barracks, Army Camp) dengan harga peningkatan yang berbeda tiap levelnya <br><br>
<img width="321" height="321" alt="image" src="https://github.com/user-attachments/assets/47998777-b79b-4e78-b6f5-06aae00c0840" />
<h5>a. Batas maksimal meningkatkan army camp dan barrack satu level diatas level Town Hall</h5>
- Army camp dan barracks hanya bisa 1 level diatas level Town Hall <br><br>
<img width="522" height="476" alt="image" src="https://github.com/user-attachments/assets/45fcac3d-c688-41dd-ab46-6ea57503adf1" />
<img width="511" height="473" alt="image" src="https://github.com/user-attachments/assets/ade9c00f-89ec-42b1-9f86-0a3b7699de05" />

<h4>4. Merekrut pasukan untuk menyerang desa musuh</h4>
- Memanggil pasukan untuk bersiap menyerang dengan power yang dikumpulkan <br><br>
<img width="431" height="221" alt="image" src="https://github.com/user-attachments/assets/1c78764b-87b4-4521-8503-3e94b8aa9e35" />
<h5>a. Level pasukan bertambah seiiring dengan meningkatnya level barracks</h5>
<img width="488" height="623" alt="image" src="https://github.com/user-attachments/assets/0be52452-cc23-44b9-a9ee-75f7c75b660b" />
<h5>b. Nama pasukan yang berbeda akan menampilkan eror</h5>
<img width="396" height="225" alt="image" src="https://github.com/user-attachments/assets/30d4013e-2b4d-4ff0-9021-f04940637e82" />
<h5>c. Armycamp yang sudah penuh tidak dapat menampung pasukan lagi</h5>
<img width="468" height="226" alt="image" src="https://github.com/user-attachments/assets/264c0c4a-d849-4db8-8636-0476fec56a60" />

<h4>5. Mengecek pasukan yang telah direkrut untuk menghitung power untuk menyerang</h4>
- Menampilkan pasukan yang telah direkrut <br><br>
<img width="850" height="243" alt="image" src="https://github.com/user-attachments/assets/bdf615c5-a314-40b3-8a87-6700c5ab2fea" />

<h4>6. Menyerang desa musuh untuk mengambil sumber daya memperkaya desa</h4>
<img width="531" height="243" alt="image" src="https://github.com/user-attachments/assets/a309f90e-6fee-459b-9e70-ea8d77c0d651" />
<h5>a. Pasukan dengan power dibawah 200 akan kalah</h5>
<img width="540" height="242" alt="image" src="https://github.com/user-attachments/assets/b7012b5c-f8b8-4e51-b915-1df4f1579ffe" />
<h5>b. Pasukan dengan power diatas 200 akan menang dan dapat 200 gold dan 100 elixir</h5>
<img width="534" height="246" alt="image" src="https://github.com/user-attachments/assets/334722f1-3ed3-4226-b7e6-8e525254a302" />
<h5>c. Pasukan dengan power >= 500 akan menang dan dapat 500 gold dan 300 elixir dan termasuk legendary victory</h5>
<img width="542" height="239" alt="image" src="https://github.com/user-attachments/assets/d41d8180-f289-4143-b88d-fbc605124c99" />

<h4>7. Keluar dari game</h4>
<img width="189" height="200" alt="image" src="https://github.com/user-attachments/assets/d2e49979-f472-4fec-a24f-28daab0da137" />

<h3>Cara Menjalankan Program</h3>
<h4>1. Buka aplikasi Apache NeatBeans</h4>
<ul>
  <li>Memilih menu file, pilih open project dan pilih Clashlite</li>
  <li>Pastikan semua package seperti app,model,service,exception terbuka di panel projects</li>
  <li>Buka setiap package untuk memudahkan berganti-ganti package nantinya</li>
</ul>

 <h4>2. Memilih file Main.java pada package MainApp</h4>
<ul>
  <li>File main.java berfungsi untuk menjalankan program yang dibuah</li>
  <li>Perannya sangat krusial karena setiap class harus memiliki perwakilan main agar bisa dijalankan</li>
</ul>
  <h4>3. Run Program</h4>
<ul>
  <li>Untuk menjalankan program kita cukup mengeklik kanan pada mouse atau cursor</li>
  <li>Cara paling mudah adalah menekan tombol f6 pada toolbar</li>
  <li>Dengan begitu aplikasi NeatBeans otomatis akan melakukan build dan terakhir melakukan eksekusi pada program yang nantinya akan menampilkan pada output</li>
</ul>
  <h4>4. Interaksi di Console</h4>
<ul>
  <li>Sebelum memulai permainan pemain diminta untuk memasukkan nama player</li>
  <li>Setelahnya program akan menampilkan menu utamanya</li>
</ul>
<ol>
  <li>Show Village</li>
  <li>Upgrade Building</li>
  <li>Recruit Troop</li>
  <li>Show Army</li>
  <li>Attack</li>
  <li>Exit</li>
</ol>
<ul>
  <li>Masukkan angka sesuai yang diinginkan, kemudian tekan enter</li>
  <li>Jika memilih Recruit Army, masukkan sesuai yang tertera</li>
  <li>Jika memilih Uprage Building, pilih bangunan yang ingin ditingkatkan terlebih dahulu</li>
  <li>Jika terdapat input salah seperti nama pasukkan yang tidak tertera maka akan muncul pesan eror dari GameException tetapi tidak akan membuat program berhenti seketika, melainkan tetap berjalan</li>
  <li>Anda dapat bermain seperti mengumpulkan sumber daya dengan menyerang, merekrut pasukan dengan power tertinggi atau terendah, meningkatkan level Town Hall agar membuka level pada barrack dan army camp</li>
</ul>
<h4>5. Exit</h4>
<ul>
  <li>Ketika memilih opsi exit maka seluruh program akan berhenti seketika, dan permainan telah selesai</li>
</ul>

<h2>Penjelasan lengkap</h2>
<h3>Link Video Youtube = </h3>
