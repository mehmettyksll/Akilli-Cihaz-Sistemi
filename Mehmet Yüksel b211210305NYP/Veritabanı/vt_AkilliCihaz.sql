PGDMP         +                z            vt_AkilliCihaz    14.2    14.2     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16394    vt_AkilliCihaz    DATABASE     m   CREATE DATABASE "vt_AkilliCihaz" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
     DROP DATABASE "vt_AkilliCihaz";
                postgres    false            ?            1259    16438    tbl_kullanicihesaplari    TABLE     ?   CREATE TABLE public.tbl_kullanicihesaplari (
    kullanici_id integer NOT NULL,
    kullanici_adi text NOT NULL,
    sifre text NOT NULL,
    yetki integer NOT NULL
);
 *   DROP TABLE public.tbl_kullanicihesaplari;
       public         heap    postgres    false            ?            1259    16410    tbl_kullanicilar    TABLE     s   CREATE TABLE public.tbl_kullanicilar (
    id integer NOT NULL,
    adi text NOT NULL,
    soyadi text NOT NULL
);
 $   DROP TABLE public.tbl_kullanicilar;
       public         heap    postgres    false            ?            1259    16452    tbl_mesajlar    TABLE     a   CREATE TABLE public.tbl_mesajlar (
    kullanici_id integer NOT NULL,
    mesaj text NOT NULL
);
     DROP TABLE public.tbl_mesajlar;
       public         heap    postgres    false            ?          0    16438    tbl_kullanicihesaplari 
   TABLE DATA           [   COPY public.tbl_kullanicihesaplari (kullanici_id, kullanici_adi, sifre, yetki) FROM stdin;
    public          postgres    false    210   [       ?          0    16410    tbl_kullanicilar 
   TABLE DATA           ;   COPY public.tbl_kullanicilar (id, adi, soyadi) FROM stdin;
    public          postgres    false    209   ?       ?          0    16452    tbl_mesajlar 
   TABLE DATA           ;   COPY public.tbl_mesajlar (kullanici_id, mesaj) FROM stdin;
    public          postgres    false    211   ?       f           2606    16444 2   tbl_kullanicihesaplari tbl_kullanicihesaplari_pkey 
   CONSTRAINT     {   ALTER TABLE ONLY public.tbl_kullanicihesaplari
    ADD CONSTRAINT tbl_kullanicihesaplari_pkey PRIMARY KEY (kullanici_adi);
 \   ALTER TABLE ONLY public.tbl_kullanicihesaplari DROP CONSTRAINT tbl_kullanicihesaplari_pkey;
       public            postgres    false    210            d           2606    16416 &   tbl_kullanicilar tbl_kullanicilar_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.tbl_kullanicilar
    ADD CONSTRAINT tbl_kullanicilar_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.tbl_kullanicilar DROP CONSTRAINT tbl_kullanicilar_pkey;
       public            postgres    false    209            ?   .   x?3??M??M-??.??442615?4?2?LI?K?M?Q\1z\\\ ,?      ?   =   x?3??M??M-??<?'?85?ˈӷ??$1-??;1'?˘ӱ???TN??ۊrS??b???? ??      ?   _   x?3??L,:??J!???????#?M?SR?R?S???*?)??7$ O?~B?&????I?e?)$??٘???rx???%??POR(??qqq >ۦM     