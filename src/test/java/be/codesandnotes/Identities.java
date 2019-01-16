package be.codesandnotes;

class Identities {

    static final int KEY_SIZE = 2048;

    /****************************************/

    static final String JAVA_USER_ID_NAME = "java";
    static final String JAVA_USER_ID_EMAIL = "java@codesandnotes.be";
    static final String JAVA_PASSPHRASE = "java passphrase";
    static final String JAVA_PRIVATE_KEYS = "-----BEGIN PGP PRIVATE KEY BLOCK-----\n" +
            "Version: BCPG v1.59\n" +
            "\n" +
            "lQPGBFsS4Q8DCACes/gePNvdxSENMWlTDIzLE8mLTR3DNd3ar9DOMy7LeraTMPRy\n" +
            "GGAbGiREcesYHmDnpJF1jVZ9GStbsY657qyIvLdLbbfs3otPNa9G69/3zXOUpox5\n" +
            "Y5LotqFoe1mVWNvP5irM8hntMn6RB4sqE4ng70OVIpVxhiMfV9seSq4NdSP6uDRz\n" +
            "HYFPMpTffHKmWQZai15LIaUTOw7YFYdt5xajJqXDU8eM5Zqox8ALqNkP1wZz3coW\n" +
            "nDSl/nNS6SK8I7OXHFQDO2eiYqS6swGoY4P1nKQ4GbMJfAZwsC1E5Jy1UBVCawgR\n" +
            "4f6/fyrB3VxudyQA88GX+7oKQpNxKgkLLDrLABEBAAH+CQMIO4Zb8ttJKFLAjUAL\n" +
            "lWW9o+BVd3RtfDRd2iPGXnCKML81+zzTEQYK8FcS2pwcMcd6D8h8QCDl9sYltXCT\n" +
            "bP7wIVcpkSk3pr6lsjDQQNxd6ukRb5vO9UNiWfce9Tl4fe3oZgOtpP0ymlKvHx+h\n" +
            "AebENhoCFDOFR8MNbFoC/gooI+JDbNScXmU4n/liBmf+ZwQFBYxOgR/WGx+8gL/t\n" +
            "Ynws5/Tp/amfmJOem0VK69xAPTcpu1q5bMl9ipMkOCPnHxoa7/+fsjlZzG7XY6pB\n" +
            "V+E1oa/LpEoDSut1u8oBc7GZajD8zuzi4gEKEkycLAxYYhaPjYdGtHQDbdjEXsY6\n" +
            "M7gAGxFRH3yncCvQx2wZnlIXmW0ksK8VrilpYLNGRTBjeI8/4QHMsOQLBHYdbI/Y\n" +
            "1II6L72uuimEMyl+tJ2S40GClL98jQwj0seGFFkYRAQSQNh9VfX35DDpJhkIQl1B\n" +
            "wftlHjtYrW4eBcMo0lFIIqTtpFzn9/0Av+liK/+Paw/FvYjoJUHaQJ7QhS5OC9yT\n" +
            "sf9YoJ58RkHARWbsEBHb081Ov6jHrFivjzZa2d3goc1LD3LXfn6rgTdqrOe1l9S0\n" +
            "grmWeaJYhawp1EcuujpOEtHD43KIjx/2HN9CzRytgzRuUnor8WiGbigFvxZyHzd3\n" +
            "r5qVs4EB1I5mguP3rLm8j/YxxQC677MihoggchTDovc6EGzSZb+ujpZkwIwCVmQL\n" +
            "RSF5PF8JggbzGntjWV/AEJy20AU7aDxEKYo35u6GIE4NwRDvMKWKhbA0E42lJobN\n" +
            "sswOAKqDPFzFw7H457y5H7pABTQOiuGznZX7m+vH+cHnA169LuaYyRrs3DYOAffL\n" +
            "SLeQqP9oiEj/TiW8eQkPpS22gkfilsdMwn2QTCNe2NsqG0Od5grkMZc1sqiJv9pJ\n" +
            "R43DNI/MwEvotBxqYXZhIDxqYXZhQGNvZGVzYW5kbm90ZXMuYmU+iQEoBBMDAgAS\n" +
            "BQJbEuEQAhsDAgsJAhUKAh4BAAoJEFj/VNcD+xahDo4H/j1Nn0huQVE1wjH/ZgS2\n" +
            "QHeKQFH+SWhUsBE2uLFWdYjtV30DkVYhuT6VtubjbU43FuvUi//uvwRFHLkOaG7f\n" +
            "so/sh6si4KnJHpxiPfFfePldDASA92i2ek71beVzx7/GvJQ60VV3OVe0rhrH+G7E\n" +
            "lf1HHdTw2Ku3D7EjF37tvaTcwuc18h84fRtSeqkESIZw+uiDLFvaounn5HZW7CSY\n" +
            "CNGXE0KsHHBk7rgWer0ydLBkHTbkSVRvUP+inM84puvZ/UTc53npUT3Sw36hXMqr\n" +
            "CHkTfTDOyFOUkoDSiCZvgXNbvM760UdgdAbLPdP5JB+flBQEz+UPbMXBcrGXIJki\n" +
            "CKGdA8YEWxLhDwEIAJ7EPUQdBjkEIK4lHgKVMUwYQqzlrqE8LUGauWhpWQqIXsjn\n" +
            "Ab3iY92+4osooUGZ2hjCn39QOsXJgFNiPXRsXKHGvESQinCicGZIBAe4XZtIwUdA\n" +
            "IgY6widIl8t3eeUYZJtpd20GNwNIweHO4VKn1yfRPdqFNxSG1nZPHqSM7X04tjD3\n" +
            "s5TxrVrEJDZQKc+nDkEqF0pYHhXJt+TS3kEFluBlMRWOPiBQBty8HYhByNvNDI8R\n" +
            "il6K1ywGoAmefcYxVP6xS7b3BiLRGeSFGIDRrI3B0jDJtEAAv1zdMXASa3uQRKSu\n" +
            "0hQmDdcNeBMNPKkyKqJEbXL8cIh2aQMFATeX/iUAEQEAAf4JAwg7hlvy20koUsCg\n" +
            "NcwRIiTbc3XimQ9cnKfrdObrRZ7gcyzgGEhJMs1tjPy2CWjbb+wfN9ZSExCc61Mu\n" +
            "BWTRQk+l1HqqUTLhYwjkXVaVLiw2Tdm9jJy/gHos2WfszShw9JBp/uSibkdm5h4n\n" +
            "8qgavR6DiF9AwfYGy/7tys8l96C/yL499XUE4MJAZ+HDiGSPXt18yJVAeOtaWV7C\n" +
            "5WZ3tQT1bolxgeSfHNE9KoK08jFYN3xe08Jwx4/KP2HyltdnCH9Vnz83bVZ+HcHZ\n" +
            "hgUZs4gNt3HVEQo9MVx/K/37ZHGywiY9VgjI7tkktzxf5sOw5eaig9Dpn4RFUQiX\n" +
            "iKzDFnsOv1yYlL85OSiX/dQiagq6TcEOPuQ7gZOOmGACHQQ5ahh28dUlqpEFnrIP\n" +
            "AinhiDgPA7qtuxHRjIJh5zyoIASBmIcPK5uiHzhPMkKXHMoma+Shq7muggVAn0Ql\n" +
            "VZoos/BDqCsnAS1Ww26gnjsP9Xs+4mMVMNMqQlsWqeuwjuEbk+S8e8EkyU7Efyxa\n" +
            "JXt/PEjRZg5Gh6+wqmnM+XrDTZDEl0trVdQledypWnRtKBylbvjqJ3AH8wYsT2tK\n" +
            "HjackhEVxBK3pcURTqTJDq+hAcRH6HLw/o9y1bc2zy4eJq94retgFMhpwNNIQQP9\n" +
            "30pXsFOr6aDwQuPAv8+Oz5uZ40g2UzCy824IvDRph2EE2pxbdknyOmDRe346cL0q\n" +
            "LV88/TZLLqvr3waBvlGF5jxHDYB1cP0P9g+28NmrvKSjjp3+cfwjVGdhY0F8EZ3v\n" +
            "Zy11s9+pBxvxO5Bjw9YoCm6RwzRG/80OIkH3pwA0cRigwLzY5PXQp0IEuwjizUXT\n" +
            "e1hXNNaR0/oYZ+ShfA0GpvFGHzyOkRlDGnGnrkPi7cytulrj00/L2cmMcKrcn/AG\n" +
            "Ow7ZPF3j9dmC1fSJAR8EGAMCAAkFAlsS4RACGwwACgkQWP9U1wP7FqFHtAf+L0FW\n" +
            "zdzmwEh2LH028+rdI48qaENzEphZM47rhPMC6Ny3Hao9WPhm9P69ltnQQgOH5Kit\n" +
            "7FvLckRIvKrmxsnmUKD+9NsFgleOfY1YTwGGmf79u3QWhjJq3kkbz5XMEuI1NuBb\n" +
            "gCdnjIrCzzPEWyUxVpTDOAuia/XkbXRGEoLIXiajCjlBPV1sVeNm2dXhlLG71ByZ\n" +
            "gsrD5WfUlgIDKv4aNqZHyyhqLKxI7kZTlshlUwzGtBKmtC3wVCss4b6iIKJ/0end\n" +
            "gJeJJXJSvJnWFhhGXx9p+VVUpwK3+3xEYyC7rLBuMlKtQestivXxgzuY1gM0Jo5+\n" +
            "9BC+0akFUnyPqF7IgA==\n" +
            "=3jo1\n" +
            "-----END PGP PRIVATE KEY BLOCK-----\n";
    static final String JAVA_PUBLIC_KEYS = "-----BEGIN PGP PUBLIC KEY BLOCK-----\n" +
            "Version: BCPG v1.59\n" +
            "\n" +
            "mQENBFsS4Q8DCACes/gePNvdxSENMWlTDIzLE8mLTR3DNd3ar9DOMy7LeraTMPRy\n" +
            "GGAbGiREcesYHmDnpJF1jVZ9GStbsY657qyIvLdLbbfs3otPNa9G69/3zXOUpox5\n" +
            "Y5LotqFoe1mVWNvP5irM8hntMn6RB4sqE4ng70OVIpVxhiMfV9seSq4NdSP6uDRz\n" +
            "HYFPMpTffHKmWQZai15LIaUTOw7YFYdt5xajJqXDU8eM5Zqox8ALqNkP1wZz3coW\n" +
            "nDSl/nNS6SK8I7OXHFQDO2eiYqS6swGoY4P1nKQ4GbMJfAZwsC1E5Jy1UBVCawgR\n" +
            "4f6/fyrB3VxudyQA88GX+7oKQpNxKgkLLDrLABEBAAG0HGphdmEgPGphdmFAY29k\n" +
            "ZXNhbmRub3Rlcy5iZT6JASgEEwMCABIFAlsS4RACGwMCCwkCFQoCHgEACgkQWP9U\n" +
            "1wP7FqEOjgf+PU2fSG5BUTXCMf9mBLZAd4pAUf5JaFSwETa4sVZ1iO1XfQORViG5\n" +
            "PpW25uNtTjcW69SL/+6/BEUcuQ5obt+yj+yHqyLgqckenGI98V94+V0MBID3aLZ6\n" +
            "TvVt5XPHv8a8lDrRVXc5V7SuGsf4bsSV/Ucd1PDYq7cPsSMXfu29pNzC5zXyHzh9\n" +
            "G1J6qQRIhnD66IMsW9qi6efkdlbsJJgI0ZcTQqwccGTuuBZ6vTJ0sGQdNuRJVG9Q\n" +
            "/6Kczzim69n9RNzneelRPdLDfqFcyqsIeRN9MM7IU5SSgNKIJm+Bc1u8zvrRR2B0\n" +
            "Bss90/kkH5+UFATP5Q9sxcFysZcgmSIIobkBDQRbEuEPAQgAnsQ9RB0GOQQgriUe\n" +
            "ApUxTBhCrOWuoTwtQZq5aGlZCoheyOcBveJj3b7iiyihQZnaGMKff1A6xcmAU2I9\n" +
            "dGxcoca8RJCKcKJwZkgEB7hdm0jBR0AiBjrCJ0iXy3d55Rhkm2l3bQY3A0jB4c7h\n" +
            "UqfXJ9E92oU3FIbWdk8epIztfTi2MPezlPGtWsQkNlApz6cOQSoXSlgeFcm35NLe\n" +
            "QQWW4GUxFY4+IFAG3LwdiEHI280MjxGKXorXLAagCZ59xjFU/rFLtvcGItEZ5IUY\n" +
            "gNGsjcHSMMm0QAC/XN0xcBJre5BEpK7SFCYN1w14Ew08qTIqokRtcvxwiHZpAwUB\n" +
            "N5f+JQARAQABiQEfBBgDAgAJBQJbEuEQAhsMAAoJEFj/VNcD+xahR7QH/i9BVs3c\n" +
            "5sBIdix9NvPq3SOPKmhDcxKYWTOO64TzAujctx2qPVj4ZvT+vZbZ0EIDh+Sorexb\n" +
            "y3JESLyq5sbJ5lCg/vTbBYJXjn2NWE8Bhpn+/bt0FoYyat5JG8+VzBLiNTbgW4An\n" +
            "Z4yKws8zxFslMVaUwzgLomv15G10RhKCyF4mowo5QT1dbFXjZtnV4ZSxu9QcmYLK\n" +
            "w+Vn1JYCAyr+GjamR8soaiysSO5GU5bIZVMMxrQSprQt8FQrLOG+oiCif9Hp3YCX\n" +
            "iSVyUryZ1hYYRl8faflVVKcCt/t8RGMgu6ywbjJSrUHrLYr18YM7mNYDNCaOfvQQ\n" +
            "vtGpBVJ8j6heyIA=\n" +
            "=LCH9\n" +
            "-----END PGP PUBLIC KEY BLOCK-----\n";

    /****************************************/

    static final String AVAJ_USER_ID_NAME = "avaj";
    static final String AVAJ_USER_ID_EMAIL = "avaj@codesandnotes.be";
    static final String AVAJ_PASSPHRASE = "avaj passphrase";
    static final String AVAJ_PRIVATE_KEYS = "-----BEGIN PGP PRIVATE KEY BLOCK-----\n" +
            "Version: BCPG v1.59\n" +
            "\n" +
            "lQPGBFsS4UgDCACPr4UElF0GEGFLy5MoRsr76v8zBrL8xjpUrjJ6bJMgcgg6cKA5\n" +
            "Dw48xvrbPGm2rF8zHEI1imENIl7mtpzQyZpo1v1tPxF+td5SRzpPpAIq9fPTAtC3\n" +
            "IMnyb5PI0lmjAxC9qIrNkRSC1frW5ZHSQT9wmi0Ll9eEuvv3vkXk3YTi06wVWpug\n" +
            "dVgRNoQlrYb60DqYZVwu94Y2qDm5BXwbFKehndkOHW+0SKPitUbV4Vi193CpTaLx\n" +
            "/q7gK3LxzkyScR5ekojCzMH1RVPL+b4ff8/Yp+8f9peXMpuvtj/1aqwKbjqh0pvB\n" +
            "I48djZxJfk84+SFZGYVbWwhVuZ3z9yFUMPipABEBAAH+CQMI0wcf52hPgsLA9drJ\n" +
            "kA43tdKri+MmAOpdSmovfFNmTV7KvJzWbHqTRk01iB6JYToka/Wm3nVqUDVqYT++\n" +
            "yNVXxMz0HsS8unpb8xOpsHu7BhzUqTezDisaAq9nf6UGfAPAyci6WadKftCpCQ32\n" +
            "Gtv67Alw5uw4k3drO0Bd3iFZimhK5YAFOxCmgGJZQfm8EdVfD/1W5WAD2UE1+7M/\n" +
            "eYTUdVlzjboPxLx8ZktguguL5SB4JUqBm7DaxWKIeMljL63ubFYzyf4uQg0zVsfc\n" +
            "DoBkR6ujk1Csnq4L84+ZY1fm0oHygrzJ0zP2ZGnGPZx/FTFCCH1DVsjZwhVD8taS\n" +
            "zHnTy3behW6KjfNUpdamiX/CKEvgDvhL+J0Bo/+NeFtxaNJC6IdyEezm5VRK2ByH\n" +
            "N5nGFQOnbE0v68JRZHzdHOfvBJModZOtewBdp/uOEON7FLVYHeE3gNwemuHREsf0\n" +
            "O0dXuRWSNbl6a2fAHNOIy2WGS/hcKOdoqtFMi9PdtG/VjBIz4S1z0C/6rmRkBc8D\n" +
            "ZmJvfjVIjA14zFEerrin5fGr3+4TZNdP2sHR9wJtR8Ny1fN9Op8UC1RXbPpTucWp\n" +
            "VUzPjR7Rv1kblZG1pDHBPdkD6zgH1XVhpeLdlmjvP0Lk7njCOhgQM0wTJoFfk5cT\n" +
            "pf7qP93wOxADP13TnZHejcWi/vrX03uyfHBzCj6m325/BWkfrsbi1qyL3giNIN4X\n" +
            "9o/uBw7m8GE8BZmLlmWpp5SeOL/EgLp7ski3QH0tkLGZ8xlobsgyskFVd593WEmt\n" +
            "sVBsWypZBeVfbDg5ERYsE44Dpi6O7SSTwXGcMFV5TYhLREJ1MWyNC980jYIycxVn\n" +
            "m8ikM5Hhskk7/Brdy/cwAIB75TanhXv06tFyJt957RaZb6h+23IcuOqPx38++H09\n" +
            "y1ZnT2UPm53atBxhdmFqIDxhdmFqQGNvZGVzYW5kbm90ZXMuYmU+iQEoBBMDAgAS\n" +
            "BQJbEuFIAhsDAgsJAhUKAh4BAAoJEE5ulM6jST7gZj0H/3rjKVU7p28mWL64165G\n" +
            "k9gTiTXzy8drNt2l403PA/kxgtjP5euI7hoNvlfWkFAp6ZKNvV+jd0sCiDPch2tg\n" +
            "tCEkubsjHHQ7u+nb9VHczCh8bl6X/h9AlIJpzADpzzxcA6PiPqL8ZIQ6tFfBLOFm\n" +
            "yQriqI9YkIjYwkfttgJsMv6ZJOwTzAtNZh75jcHFdL++GczQhT9tuVoxUjc5coFZ\n" +
            "iN/meHl1mGDtCD0cME3V3wTqLdAj73HX2eGCjcL+CCrVnnvY8c9MYYC7P/JUQigh\n" +
            "l9TdoWe2k6yfIWAKMMGnZXWFGDSRxNTAnhyfL5Kas01KjQd6bNlV4q9arM66uHHg\n" +
            "qSKdA8YEWxLhSAEIAJ/54U2XXFjsBa4m9wJ/7YZja4/qzuGAthA5/p4M50d4CFHl\n" +
            "x2XXzGlrQRAkGzqjpfxHE6vE/zupuGnDAsZ7j6zxGsqpV/rE9RxbLqslf7gQIzqP\n" +
            "DGLCE3Es3PjJEnmIdMvsBH4MuBRy0/XKSj0tskagwR9xu6nurbIAhR0d6fRC6kEw\n" +
            "PaaZSPezO+2j4Rqrs9l82F+Da3PkP0/P9Hg76uyLX7NbmxCeftERUl4VvjbfZneT\n" +
            "gsuaLpnNuk0n+IbYLcGGDXskEI4POlh3FlF3Csrn1z1MasYNuFCw8cXTDSlRjjx/\n" +
            "Adr0zyLC0B9aeCeAyzJaESDjBgihpVlCU1aGAVMAEQEAAf4JAwjTBx/naE+CwsDA\n" +
            "KTMHop/m5arW36Op8jliK8NWBoAqvXGwg5j5zkcdiLgS9djZzSbW4ZVq0lFmgvNL\n" +
            "mfiM35nqwh8b9zmERWAZlNBvblvy6wcVJ+OxrkZz4diYWYX60TDBXdBqwtEPnyv8\n" +
            "EB8FvOKiVHCCWurB/SFFdXFWm3A1wv9EWRiEoIXdzzkFQIvwP7ukTEx4ATDXIutI\n" +
            "3KJsQoFIaMptv9AXjE4PzhebjfF5KZeIhkItQOHu2Q7pSi765Z0PjYKFM0AtiQiY\n" +
            "8sPf56Gr/ptB1/J0q4Xq8zKhx7AfQi8nRgE6xJvErJ5xaOuRUsJjRasT7H6cHprN\n" +
            "u3EWD0ZbXt9dMVSQHSG9K1jHhNQI2WDDCDMSW5kFGBHY1OYeFfkabu7PWR/08OEJ\n" +
            "IYuNeNX3drLEPzsRqATQR+meAfBu9/4e/SZeVZyM589662uwf3BSl2DRAf72Ytcz\n" +
            "VGFqDyOvb0VXcVjcRXHbGLNXtnyJJwvwvQdfgfGbCRVK+OzvHWUz5MeGdG6Z5fe1\n" +
            "KYghxlDrFHxsiOBZ4Jbzfu756AiTUhiAZbydS3LVLUZNrpSaJ2S+TBv6X2DbxE1D\n" +
            "2aI4B24gOGhpAF/nUdf/MI9OSmm/Nb1ZEZnihWZGGFIzOGwx4HXXSgLfzWh2ByMU\n" +
            "zy++b8VNSH7eS9OV/RCnWgxZKlTPIYyyGFTZebHEIdeJwHL7DuEz3kOSjET2Dg9U\n" +
            "wAiVJfuHCGo7aEO1ZlPGdtgQBlUruIrP2mu2ZBwjpOAtlopOluIrFVMuJ3MjxLbS\n" +
            "52oQxHqYd+OEdG6t4vXbVvjcjMa9xkAzOgYKcaazHmGAxnn/spAGAZA5QIrnztW4\n" +
            "iA5WoptInP6PHqq5yJ1nLmVjZ0NpXizr0e+eB+pe8bQqNrRWCpKNHyIVS5O0Jqwi\n" +
            "QKSdXMuv+NhW0CyJAR8EGAMCAAkFAlsS4UgCGwwACgkQTm6UzqNJPuAcZggAiFF5\n" +
            "VxX4fE0zxiluXi40sDDAE5kUzgFQWfTmUNrk6Dkyhh30D6GmutswHPlf78kfEQ4L\n" +
            "qGfIl3tM6Z7XiXN4ZAZ1+i1z+YUMJiGWFJQPg1dxlHMiQwoZLPjIV2De1hFMR9O4\n" +
            "EmQ91rLO43brj/79pytYodWQGfDfMSWQPjUBjXLq+RDUYVq7DNH9ovYMo8hvCT9m\n" +
            "uP1WeoXYN3R0HmgsEYjP336hvTRRnYtKr8TF+yEAYkuvZ0WFHCny4ScDSSFsyF23\n" +
            "ctsz4lelThya44phXJxZz/SzN59YOFk7Qdbp9ttTwtJ5eUfzaHhlN3aQnNhMb80Q\n" +
            "f1MQNb1Nzsi0t6zCLA==\n" +
            "=EMEP\n" +
            "-----END PGP PRIVATE KEY BLOCK-----\n";
    static final String AVAJ_PUBLIC_KEYS = "-----BEGIN PGP PUBLIC KEY BLOCK-----\n" +
            "Version: BCPG v1.59\n" +
            "\n" +
            "mQENBFsS4UgDCACPr4UElF0GEGFLy5MoRsr76v8zBrL8xjpUrjJ6bJMgcgg6cKA5\n" +
            "Dw48xvrbPGm2rF8zHEI1imENIl7mtpzQyZpo1v1tPxF+td5SRzpPpAIq9fPTAtC3\n" +
            "IMnyb5PI0lmjAxC9qIrNkRSC1frW5ZHSQT9wmi0Ll9eEuvv3vkXk3YTi06wVWpug\n" +
            "dVgRNoQlrYb60DqYZVwu94Y2qDm5BXwbFKehndkOHW+0SKPitUbV4Vi193CpTaLx\n" +
            "/q7gK3LxzkyScR5ekojCzMH1RVPL+b4ff8/Yp+8f9peXMpuvtj/1aqwKbjqh0pvB\n" +
            "I48djZxJfk84+SFZGYVbWwhVuZ3z9yFUMPipABEBAAG0HGF2YWogPGF2YWpAY29k\n" +
            "ZXNhbmRub3Rlcy5iZT6JASgEEwMCABIFAlsS4UgCGwMCCwkCFQoCHgEACgkQTm6U\n" +
            "zqNJPuBmPQf/euMpVTunbyZYvrjXrkaT2BOJNfPLx2s23aXjTc8D+TGC2M/l64ju\n" +
            "Gg2+V9aQUCnpko29X6N3SwKIM9yHa2C0ISS5uyMcdDu76dv1UdzMKHxuXpf+H0CU\n" +
            "gmnMAOnPPFwDo+I+ovxkhDq0V8Es4WbJCuKoj1iQiNjCR+22Amwy/pkk7BPMC01m\n" +
            "HvmNwcV0v74ZzNCFP225WjFSNzlygVmI3+Z4eXWYYO0IPRwwTdXfBOot0CPvcdfZ\n" +
            "4YKNwv4IKtWee9jxz0xhgLs/8lRCKCGX1N2hZ7aTrJ8hYAowwadldYUYNJHE1MCe\n" +
            "HJ8vkpqzTUqNB3ps2VXir1qszrq4ceCpIrkBDQRbEuFIAQgAn/nhTZdcWOwFrib3\n" +
            "An/thmNrj+rO4YC2EDn+ngznR3gIUeXHZdfMaWtBECQbOqOl/EcTq8T/O6m4acMC\n" +
            "xnuPrPEayqlX+sT1HFsuqyV/uBAjOo8MYsITcSzc+MkSeYh0y+wEfgy4FHLT9cpK\n" +
            "PS2yRqDBH3G7qe6tsgCFHR3p9ELqQTA9pplI97M77aPhGquz2XzYX4Nrc+Q/T8/0\n" +
            "eDvq7Itfs1ubEJ5+0RFSXhW+Nt9md5OCy5oumc26TSf4htgtwYYNeyQQjg86WHcW\n" +
            "UXcKyufXPUxqxg24ULDxxdMNKVGOPH8B2vTPIsLQH1p4J4DLMloRIOMGCKGlWUJT\n" +
            "VoYBUwARAQABiQEfBBgDAgAJBQJbEuFIAhsMAAoJEE5ulM6jST7gHGYIAIhReVcV\n" +
            "+HxNM8Ypbl4uNLAwwBOZFM4BUFn05lDa5Og5MoYd9A+hprrbMBz5X+/JHxEOC6hn\n" +
            "yJd7TOme14lzeGQGdfotc/mFDCYhlhSUD4NXcZRzIkMKGSz4yFdg3tYRTEfTuBJk\n" +
            "PdayzuN264/+/acrWKHVkBnw3zElkD41AY1y6vkQ1GFauwzR/aL2DKPIbwk/Zrj9\n" +
            "VnqF2Dd0dB5oLBGIz99+ob00UZ2LSq/ExfshAGJLr2dFhRwp8uEnA0khbMhdt3Lb\n" +
            "M+JXpU4cmuOKYVycWc/0szefWDhZO0HW6fbbU8LSeXlH82h4ZTd2kJzYTG/NEH9T\n" +
            "EDW9Tc7ItLeswiw=\n" +
            "=htBv\n" +
            "-----END PGP PUBLIC KEY BLOCK-----\n";

    /****************************************/

    static final String JAVASCRIPT_USER_ID_NAME = "javascript";
    static final String JAVASCRIPT_USER_ID_EMAIL = "javascript@codesandnotes.be";
    static final String JAVASCRIPT_PASSPHRASE = "javascript passphrase";
    static final String JAVASCRIPT_PRIVATE_KEYS = "-----BEGIN PGP PRIVATE KEY BLOCK-----\n" +
            "Version: OpenPGP.js v3.0.11\n" +
            "Comment: https://openpgpjs.org\n" +
            "\n" +
            "xcMGBFsQ+JsBCACtCRk+NDuWzKRupUntt/lNdRe/mIQzOFXSN0O5WAuRvgkj\n" +
            "0Bk5cOOBLHRIGSATYDpxpe5pO77+idDzPOS3YHD83qFUHyWgGCyq7LFhh6Pw\n" +
            "aTv8WGnhGQjm7SHXR9A1g4P80yNxnbnkIU2XHsZSzhaWi6NM4ATytStQPcnb\n" +
            "xDL84c4XZomCTKE/WLToUOv86YQ+IIyEoUyi+9Rp/HmQPK6CJ8FZKgKTcZdU\n" +
            "ZZNKgdPYuuSCUaOs1xQx1uJyY1gCdEZ0UEEyfJWEknpSd+MmA2i7dEYBZjOQ\n" +
            "okHR8Of5kxW4t9+PW2XDi28A/THCWZBzlPB/yd2G54DftuS22uaS4Kf9ABEB\n" +
            "AAH+CQMIst/M9pGLt6hg9Kw6cTUBO88DcouXftUenlC66iDQtnZm3lgqCnSc\n" +
            "vUFtnS6S3b7p7ioV2WpjrSCqiCgLjGoMmpJsNWM6RudMoNUOo2S6wlJbQkiB\n" +
            "qtT1UwkEWIh6mVF4NMA0n2Tkvf2m9gZsWmerF2K/7ADhPj6fkm0JQxRROZrl\n" +
            "Nk1keKQgNzX0AVLauZCT4LQDT31AdlfTSUiBecyOWxEv8SLiMS7yl0Y7xlZD\n" +
            "Zjtz8UyhxLkB91DTCG8ku/HRukeKrNsnrZSKRYeBFD/xygx3bgEzAveIA1iW\n" +
            "xAAfzmU8b6+sZ26U71GFopTvhoF0m7lv/8Rna1G5icaRPUa2Ovc3h8GJiuKu\n" +
            "dtHl7xy/29jsROOxpiwW/gNeLibSuIXhWXGlssUJseRJk9O8WB+hNNdojHgy\n" +
            "pgzgfBe0uFVKu1bay5fcQ0l9tiO7FAUs5uJRiMuCsGs+66cezulgRS6hGEv6\n" +
            "xefuFp3n+iApOa8a4JEGE6YNy2RNpb1Vh/uBaw2JhwZ5GKIfBQ/2AOIGbIcZ\n" +
            "wnW2SAzQ69Z3yVZDDTn0aq/pcOsHJ8nmpcn0ahbdCGwnO6xYrdgxZzqjzIu7\n" +
            "9GzebOiAeq8TWvmhicmNjmP8DVNeecnHymc1Z6j/t0MmW5gKm7I69wD0E0+s\n" +
            "NF5ZFWS1W/nDMfS/8h7s7fwH/rD5/c7XAVRdFOyTCZYvVb4KpCCU+FmTTz2d\n" +
            "oLZ/GOvMGoVz8m3HbMC0GmKXHdodNJHQrgNrXi3Nl+Gwhe9N+quitJYpI4Qw\n" +
            "ecOwobH3ay9sm/7dgErol3e3KRWI9j8CR24o7XN4Y19atgPIqBDn+/JpFnYK\n" +
            "8SLbCkrUpTIv7TEOLD+twdoQgH+XH9MaafRbfEWGiFA2J/O5+HMDv8vvlLjm\n" +
            "CY3Dwi9rsUjJi/uk59pyOM6/6id0mYwbzShqYXZhc2NyaXB0IDxqYXZhc2Ny\n" +
            "aXB0QGNvZGVzYW5kbm90ZXMuYmU+wsB1BBABCAApBQJbEPibBgsJBwgDAgkQ\n" +
            "bUcvXIl1UNAEFQgKAgMWAgECGQECGwMCHgEAAKQlB/9SAVkqfpw6j0qDn8Ti\n" +
            "XtEp+GeDGPnjCCj3i4PT2Q2KWqWyaY1lCwTor6QLT4eyTgJlU+peefdKOZis\n" +
            "+l0KYLMa2ejOMt3vmYsfxjXPe+S+xUikhvYgTdiEDwRdSE97WS6CuYQKUhe4\n" +
            "L27NtLbpnhDdPaXvGQAERP+y45sx1tuzZrIVnHdYw84qs9F8YsZoJU30u2j6\n" +
            "UeaUM9wd+YyeyGfVL0/xH2RjTMM9wLBy0Pg8b2KoVaOEwo6WebaNtn1rGqN/\n" +
            "RQViogJPcvslZ83w43GUDz8Jx1YghHL6215G80FfIytgMQ9YdIIV0klOkRrH\n" +
            "ZPS2CnbMZVz+f9A9JeLzaUpix8MGBFsQ+JsBCACrBpXYWq4ojycFlgmXNHK6\n" +
            "ud6iJTlltzenfGaYnD+0uWvWiZ8vfZGVy2MUACPu6YT9YHr1g/VAkgYQMWRP\n" +
            "U2tVtFJ/EUFbueJzoxHJU+mVCfvI3h9WN8lg6z85SMZfDBzuCrbDJ0mGsYNU\n" +
            "JNLa+YesdbCGFR/A+ah0tf6dDegYC1axtMdI1ibI86/kJISCnpIa06Mybxpo\n" +
            "kzXEvmqQQp51LSx+dKDzsUFG4uJ7iXS/izuyl7fJRhSJiq112MphITPyLo7b\n" +
            "59mqopyLBNd8+UAXuxE6zU8w7NmhN51XK+DGjf+xP0BrE8WloonoHL+r9+Y2\n" +
            "4nDQE5607Z2fKMrpXBglABEBAAH+CQMIzqyMmq8RNq9gT+xrcfscA7Btpofr\n" +
            "uifowWLuBmgzORQVQCC7WYot9q3CWAh8QN5fA26LownSmPy3FbuAGafEEGnN\n" +
            "kCRlmeuy2hibtdcjWuPxivFcS8yVbOFsnFSeXTHVeIGM4kB4UmGUY3Unxd45\n" +
            "rsT82vqwq18JyIG5EMnN+AtdINHZ6sBqAD0R439Y4Zq0AkcNW8d+br8WTBxW\n" +
            "J4rNuIov66dUFG2bASah9BGs9oQ3GXA5s/TAEWrjavqfT45+ZlC4SrbkQvEZ\n" +
            "aKDc5jy9z8KGJN4YyXfUaugGU0Ja0vXnCE2fRePNnqL8Lw/JHzRev0/jSort\n" +
            "qMbmBf2+4KYn5RUUVNbbDpaZbU7PZtAwLSVEc8nuSfWmLEPTGgEMbtYmJAzr\n" +
            "VE1Asks1p12oWnGElvrwIlrmHOPd04b3KCozXs3X+ujrwccAJCeeKe+C9lot\n" +
            "UIt2Ec8Bj5Qpr4F9zN8XutWPFMh0gj6twLjAIOnvqkg2mPMSLkuXYVn1V5c7\n" +
            "82ctUlwfb2Dsa2DnWG0wDlUZ6vfmo8S/PR12YQe49pKnTTvi0/Q7Kzk1Tc+K\n" +
            "HBcawnY84EuJxTQbaSlGBNzLl39DbMxciqIaepk8LbDewQJKfjW+EkjNDNX2\n" +
            "SD7rLqTz6zTaC2O/2hblOWnKz/nARZmNvZbP52I1n3hrogBLc13BBjyaQoeK\n" +
            "YWdsf5Ck2U+1hFgQXCUM+J67ArWMfVHjN1tw5UbRgm5oMk2mDABKggPDPuJ1\n" +
            "4BWd4DjYpkmryHfRb5RKQLd/oIuxqKs+o0VBbQNB50kJTAktJTUhRSlVNh29\n" +
            "oA1aezq0o2w3nos8dP7gZdjESNrJ1pUeuNXbL/UOoL6MQQW0Ih5oZg4CrtLI\n" +
            "bYdc+uU7pwG8qMQXSUEdbCpqMF1ZCvquTokFZDLZ7iR/2NLOTfIJTwghwsBf\n" +
            "BBgBCAATBQJbEPibCRBtRy9ciXVQ0AIbDAAAowAH/i4qL4IdehXuj87Sun5U\n" +
            "5nFhy8F/WSazBZcTOXF1vUjj+zuQgNIdlqDEgQB8y6VhRtvP83xuBaLfwI+W\n" +
            "pesP6CNWukw6G/ULlZHyiQgTi8CmJhxhKh39i5kdfH/gyRuHlvIWIBl1c4Mx\n" +
            "UDzC8HdTB14CMSN5n3kH0jb83M/yYwtU7Y9MbnqPGIjVcZ7hO8ztZ9nY37kB\n" +
            "Q8zqpIrijaNhFhkvn1+x41IuEQDLErY/eb7OI2fDJo45IQK4wwVAwy0oDzar\n" +
            "7N3kAGytFjRNIwIRLceu6tW1d3SYuGoPs3V1yHQUczT6W4OMqRP/LAnrz0y6\n" +
            "kdaym7GpBV4S4YAJ9uSWDAY=\n" +
            "=ZHJ7\n" +
            "-----END PGP PRIVATE KEY BLOCK-----\n";
    static final String JAVASCRIPT_PUBLIC_KEYS = "-----BEGIN PGP PUBLIC KEY BLOCK-----\n" +
            "Version: OpenPGP.js v3.0.11\n" +
            "Comment: https://openpgpjs.org\n" +
            "\n" +
            "xsBNBFsQ+JsBCACtCRk+NDuWzKRupUntt/lNdRe/mIQzOFXSN0O5WAuRvgkj\n" +
            "0Bk5cOOBLHRIGSATYDpxpe5pO77+idDzPOS3YHD83qFUHyWgGCyq7LFhh6Pw\n" +
            "aTv8WGnhGQjm7SHXR9A1g4P80yNxnbnkIU2XHsZSzhaWi6NM4ATytStQPcnb\n" +
            "xDL84c4XZomCTKE/WLToUOv86YQ+IIyEoUyi+9Rp/HmQPK6CJ8FZKgKTcZdU\n" +
            "ZZNKgdPYuuSCUaOs1xQx1uJyY1gCdEZ0UEEyfJWEknpSd+MmA2i7dEYBZjOQ\n" +
            "okHR8Of5kxW4t9+PW2XDi28A/THCWZBzlPB/yd2G54DftuS22uaS4Kf9ABEB\n" +
            "AAHNKGphdmFzY3JpcHQgPGphdmFzY3JpcHRAY29kZXNhbmRub3Rlcy5iZT7C\n" +
            "wHUEEAEIACkFAlsQ+JsGCwkHCAMCCRBtRy9ciXVQ0AQVCAoCAxYCAQIZAQIb\n" +
            "AwIeAQAApCUH/1IBWSp+nDqPSoOfxOJe0Sn4Z4MY+eMIKPeLg9PZDYpapbJp\n" +
            "jWULBOivpAtPh7JOAmVT6l5590o5mKz6XQpgsxrZ6M4y3e+Zix/GNc975L7F\n" +
            "SKSG9iBN2IQPBF1IT3tZLoK5hApSF7gvbs20tumeEN09pe8ZAARE/7LjmzHW\n" +
            "27NmshWcd1jDziqz0XxixmglTfS7aPpR5pQz3B35jJ7IZ9UvT/EfZGNMwz3A\n" +
            "sHLQ+DxvYqhVo4TCjpZ5to22fWsao39FBWKiAk9y+yVnzfDjcZQPPwnHViCE\n" +
            "cvrbXkbzQV8jK2AxD1h0ghXSSU6RGsdk9LYKdsxlXP5/0D0l4vNpSmLOwE0E\n" +
            "WxD4mwEIAKsGldhariiPJwWWCZc0crq53qIlOWW3N6d8ZpicP7S5a9aJny99\n" +
            "kZXLYxQAI+7phP1gevWD9UCSBhAxZE9Ta1W0Un8RQVu54nOjEclT6ZUJ+8je\n" +
            "H1Y3yWDrPzlIxl8MHO4KtsMnSYaxg1Qk0tr5h6x1sIYVH8D5qHS1/p0N6BgL\n" +
            "VrG0x0jWJsjzr+QkhIKekhrTozJvGmiTNcS+apBCnnUtLH50oPOxQUbi4nuJ\n" +
            "dL+LO7KXt8lGFImKrXXYymEhM/Iujtvn2aqinIsE13z5QBe7ETrNTzDs2aE3\n" +
            "nVcr4MaN/7E/QGsTxaWiiegcv6v35jbicNATnrTtnZ8oyulcGCUAEQEAAcLA\n" +
            "XwQYAQgAEwUCWxD4mwkQbUcvXIl1UNACGwwAAKMAB/4uKi+CHXoV7o/O0rp+\n" +
            "VOZxYcvBf1kmswWXEzlxdb1I4/s7kIDSHZagxIEAfMulYUbbz/N8bgWi38CP\n" +
            "lqXrD+gjVrpMOhv1C5WR8okIE4vApiYcYSod/YuZHXx/4Mkbh5byFiAZdXOD\n" +
            "MVA8wvB3UwdeAjEjeZ95B9I2/NzP8mMLVO2PTG56jxiI1XGe4TvM7WfZ2N+5\n" +
            "AUPM6qSK4o2jYRYZL59fseNSLhEAyxK2P3m+ziNnwyaOOSECuMMFQMMtKA82\n" +
            "q+zd5ABsrRY0TSMCES3HrurVtXd0mLhqD7N1dch0FHM0+luDjKkT/ywJ689M\n" +
            "upHWspuxqQVeEuGACfbklgwG\n" +
            "=3sO0\n" +
            "-----END PGP PUBLIC KEY BLOCK-----\n";
}
