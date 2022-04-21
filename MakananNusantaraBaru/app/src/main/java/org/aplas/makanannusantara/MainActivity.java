package org.aplas.makanannusantara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.aplas.makanannusantara.model.Makanan;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter makananAdapter;
    private ArrayList<Makanan> makananArrayList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        getDataFromInternet();
        prosesRecyclerViewAdapter();

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem searchIem = menu.findItem(R.id.search_view);

        final androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) searchIem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String nextText) {
                nextText = nextText.toLowerCase();
                ArrayList<Makanan> dataFilter = new ArrayList<>();
                for (Makanan data : makananArrayList) {
                    String nama = data.getNama().toLowerCase();
                    if (nama.contains(nextText)) {
                        dataFilter.add(data);
                    }
                }
                makananAdapter.setFilter(dataFilter);
                return true;
            }
        });
        return true;
    }

    private void prosesRecyclerViewAdapter(){
        recyclerView = findViewById(R.id.recyclerView);
        makananAdapter = new RecyclerViewAdapter(this, makananArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(makananAdapter);
    }

    private void getDataFromInternet(){
        makananArrayList.add(new Makanan("https://cdnt.orami.co.id/unsafe/468x293/cdn-cas.orami.co.id/parenting/images/makanankhas1.width-800.jpg","Nasi Tumpeng","Makanan khas Nusantara yang pertama adalah nasi tumpeng,Nasi tumpeng biasa disajikan dalam acara-acara khusus atau acara penting. Nasi tumpeng biasa terbuat dari nasi kuning berbentuk kerucut tinggi dengan berbagai lauk pelengkap di sekelilingnya,Meskipun saat ini telah disajikan dengan berbagai macam bentuk, namun bentuk asli dari nasi tumpeng adalah kerucut yang menyerupai gunung,Masyarakat Jawa melambangkan gunung sebagai tempat yang dekat dengan langit dan surga. Maksudnya adalah menempatkan Tuhan pada posisi tertinggi yang menguasai alam dan manusia. Semua yang berasal dari Tuhan dan akan kembali pula ke Tuhan,Bentuk menggunung nasi tumpeng juga dipercaya mengandung harapan agar hidup kita semakin naik dan memperoleh kesejahteraan yang tinggi,Nama nasi tumpeng memiliki kepanjangan ‘yen metu kudu mempeng’ atau kalau keluar harus bersemangat. Lauk-pauk yang ada di tumpeng berjumlah tujuh dalam Bahasa Jawa berarti pitu, makna dari kata pitu adalah pitulungan atau pertolongan."));
        makananArrayList.add(new Makanan("https://cdnt.orami.co.id/unsafe/468x311/cdn-cas.orami.co.id/parenting/images/makanankhas3.width-800.jpg","Ketupat","Makanan berbentuk segiempat yang identik dengan bulan Ramadan ini juga memiliki filosofi yang menarik. Tahukah Moms mengapa makanan khas Nusantara satu ini hanya disajikan di bulan Ramadan saja?,Idul Fitri identik dengan momen untuk saling memaafkan dan makanan yang paling cocok menggambarkan hal ini adalah kupat, “Ngaku lepat” adalah filosofi di balik makanan ini yang bisa diartikan mengakui kesalahan. Makanya, ketupat hanya afdol dimakan ketika satu sama lain saling meminta maaf dan mengakui kesalahan,Dan ada empat hal yang bisa diresapi yaitu Lebaran artinya usai yang mengibaratkan pintu ampunan terbuka lebar, luberan artinya melimpah yang menyimbolkan ajaran untuk bersedekah, leburan artinya melebur yang mengajarkan untuk saling memaafkkan, dan laburan artinya kapur yang melambangkan kesucian lahir dan batin."));
        makananArrayList.add(new Makanan("https://cdnt.orami.co.id/unsafe/468x311/cdn-cas.orami.co.id/parenting/images/makanankhas5.width-800.jpg","Dawet","Siapa yang tidak tahu minuman bersantan yang dicampur dengan gula jawa dan cendol ini? Apalagi kalau bukan es dawet, Minuman segar satu ini, selain rasanya yang enak dan lezat, makanan khas Nusantara ini juga memiliki filosofi yang unik lho, Nama cendol sendiri berasal dari jendol yang memiliki arti gumpalan. Merepresentasikan sensasi saat menyantap isian dawet yang bergumpal-gumpal. Sedangkan di minuman dawet ayu, ada lambang Semar dan Gareng yang memiliki makna harapan agar dagangannya laris manis, Pada pernikahan adat Jawa, dawet tak hanya dihidangkan di atas meja, namun disajikan sebagai rangkaian upacara pernikahan yang dikenal dengan dodol dawet artinya berjualan dawet, Mengapa? Karena ternyata bentuk cendol yang bulat melambangkan kebulatan kehendak orangtua untuk menjodohkan anak, Para tamu undangan diperkenankan untuk membeli dawet tersebut tapi tidak menggunakan uang, melainkan menggunakan kreweng (koin yang terbuat dari tanah liat). Hal ini menandakan bahwa sebenarnya hidup manusia berasal dari bumi, Ibu calon mempelai wanita bertindak melayani pembeli, sementara sang ayah menerima pembayaran. Hal ini mengajarkan kepada pasangan yang menikah tentang bagaimana mencari nafkah sebagai suami istri , harus saling membantu satu sama lain."));
        makananArrayList.add(new Makanan("https://cdnt.orami.co.id/unsafe/468x468/cdn-cas.orami.co.id/parenting/images/sayur_lodeh.width-800.jpg","Sayur Lodeh","Sayur lodeh umum disajikan sebagai hidangan di rumah. Namun makanan khas Nusantara satu ini memiliki arti unik jika disajikan dalam sebuah acara lho. \n Pada acara selametan, sayur lodeh dihidangkan karena dilambangkan sebagai tolak bala. Hal ini tidak terlepas dari 12 komponen penyusunnya yaitu labu kuning, kacang panjang, terong, kluwih, daun so, kulit mlinjo, labu siam, pepaya muda, nangka muda, kobis, sayur bayung dan kecambah kedelai.Ternyata, angka 12, juga dapat dijumlah sebagai 1+2 menghasilkan angka 3. Angka ini dalam filosofi Jawa berarti upaya meraih kehidupan masyarakat yang dilindungi oleh Tuhan yang Maha Kuasa.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Sementara, komponen pokok sayur lodeh yaitu labu kuning yang dalam bahasa Jawa disebut waluh memiliki arti wal (lepas) dan luh (air mata). Maksudnya membebaskan manusia dari tetes air mata, peluh atau penderitaan.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Santan sayur kelapa hijau biasa digunakan oleh masyarakat tradisional untuk penawar racun. Santan dalam sayur ini juga menjadi simbol penawar racun duniawi. Karena kemewahan duniawi bisa menjadi racun bagi manusia."));
        makananArrayList.add(new Makanan("https://cdnt.orami.co.id/unsafe/468x337/cdn-cas.orami.co.id/parenting/images/3-mie_kocok.width-800.jpg","Mie Kocok Bandung","Orang Bandung pasti sudah sangat mengenal makanan khas Nusantara satu ini. Sesuai namanya, mie kocok merupakan makanan khas dari kota bandung yang memiliki rasa segar, gurih, dan juga nikmat.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Dalam mie kocok, Moms akan menemukan beberapa bahan makanan seperti mie gepeng, sayur tauge, dan juga potongan kikil.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Penasaran bagaimana rasa semangkok mie kocok Bandung? Jika sedang berkunjung ke kota ini, jangan lupa mencicipinya ya Moms. Banyak dari masyarakat bandung bahkan dari luar daerah yang sangat menyukai mie kocok, lho."));
        makananArrayList.add(new Makanan("https://cdnt.orami.co.id/unsafe/468x312/cdn-cas.orami.co.id/parenting/images/gudeg.width-800.jpg","Gudeg Jogja","Jika Moms berkunjung ke Jogjakarta, merupakan sebuah kewajiban untuk Moms mencoba makanan khas Nusantara dari Jogja satu ini.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Gudeg merupakan hidangan yang terbuat dari bahan nangka muda yang dimasak dengan rempah yang lengkap dan juga diberi gula merah sehingga rasanya manis.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Gudeg biasanya disajikan bersama dengan berbagai macam lauk lainnya yang tidak kalah lezat, seperti ayam, telur, tempe atau tahu bacem istimewa."));
        makananArrayList.add(new Makanan("https://cdnt.orami.co.id/unsafe/468x274/cdn-cas.orami.co.id/parenting/images/lumpia_basah.width-800.jpg","Lumpia Semarang","Jika berkunjung ke Semarang, biasanya kita akan membeli lumpia sebagai oleh-oleh. Seperti Moms ketahui, kulit lumpia terbuat dari tepung gandum, kemudian diisi dengan berbagai macam sayuran segar dan daging. Biasanya lumpia memiliki cita rasa gurih dan asin.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Kualitas kulit dan pengolahan bahan isi lumpia menjadi kunci kenikmatan makanan khas Semarang ini. Ada dua jenis lumpia yang bisa Moms cicipi jika datang ke Semarang, yakni lumpia goreng dan lumpia basah.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Sudahkah Moms mecicipi kedua makanan khas Nusantara ini? Mana yang Moms suka?"));
        makananArrayList.add(new Makanan("https://cdnt.orami.co.id/unsafe/468x555/cdn-cas.orami.co.id/parenting/images/lempah.width-800.jpg","Lempah Ikan Tenggiri dengan Belimbing Wuluh","Lempah ikan tenggiri dengan belimbing wuluh merupakan sajian makanan khas Nusantara dari Pulau Bangka Belitung yang menggunakan ikan kakap atau tenggiri sebagai bahan utamanya.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Bayangkan lezatnya ikan kakap atau tenggiri yang dilumuri dengan kuah bumbu kuning kemerahan dari kunyit dan cabai, serta ditambahkan irisan belimbing wuluh dan nanas yang memberikan aroma dan rasa yang segar.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Jika berkungjung ke Bangka Belitung, jangan lupa mencoba hidangan satu ini ya Moms. Atau jika ingin mencoba memasak sendiri di rumah dengan resep dari internet juga bisa Moms."));
        makananArrayList.add(new Makanan("https://ds393qgzrxwzn.cloudfront.net/resize/m720x480/cat1/img/images/0/IAPkgtg7dj.jpg","Rendang","Kebanyakan dari kita kalau ke restoran Padang pasti langsung pesan rendang. Tak salah memang karena ini merupakan masakan nusantara yang melegenda. Bahkan makanan ini berada di posisi pertama dalam jajaran 50 makanan dunia terenak versi CNN, lho."));
        makananArrayList.add(new Makanan("https://cdnt.orami.co.id/unsafe/468x585/cdn-cas.orami.co.id/parenting/images/92033111_3741860742522278_3972302592045164917_.width-800.jpg","Bakpia Kukus","Makanan khas Nusantara satu ini memang sudah sangat populer sebagai oleh-oleh khas kota Yogyakarta.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Tapi Moms tahu tidak sih kalau Bakpia sekarang punya beraneka ragam rasa yang enak-enak dan menarik, lho? Bahkan nih, sekarang ada jenis baru yang namanya Bakpia Kukus.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Beda dari jenis Bakpia biasa, tekstur kulit dan isian Bakpia kukus lebih lembut dari Bakpia pada umumnya dan mirip bolu karena hasil dari proses kukus.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Tidak hanya teksturnya yang beda, Bakpia Kukus juga punya pilihan rasa mulai dari cokelat, kacang hijau, keju, dan kacang merah. Terdengar lezat dan menarik kan Moms? Jangan lupa cobain saat berkunjung ke Yogya ya!"));
    }
}