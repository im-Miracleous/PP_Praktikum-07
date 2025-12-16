/*
 * PRAKTIKUM 07 "IN234 Paradigma Pemrograman"
 * Nama Program : Radix
 * Deskripsi    : Enum yang mendaftarkan rasio/radix dari bentuk bilangan (desimal/biner/oktal/heksa).
 * Penulis      : Miracle Steven Gerrald
 * NRP          : 2472019
 */

public enum Radix {
    BINARY(2),
    OCTAL(8),
    DECIMAL(10),
    HEXADECIMAL(16);

    private final int conversion;

    Radix(int conversion) {
        this.conversion = conversion;
    }

    public int getConversion() {
        return conversion;
    }
}
