<h1>Digital Signature with MD5 & RSA</h1>

<p>Perangkat lunak menggunakan bahasa java yang menerapkan Tanda Tangan Digital dengan kombinasi fungsi hash MD5 dan Kriptografi Kunci publik Algoritma RSA</p>

<p>Pada skema tanda tangan digital, proses yang dilakukan adalah melakukan hash terhadap nilai pesan. Hasil hash kemudian di-enkripsi menggunakan kunci privat yang telah di-generate oleh sistem sehingga menghasilkan nilai tanda tangan digital yang kemudian akan disisipkan kepada file.</p>

<p>Proses otentikasi pengirim dilakukan dengan mendekripsi tanda tangan dan mencocokkan hasil dekripsi dengan nilai hash pesan.</p>

