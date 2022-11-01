ANGSTROM_URI = "http://feeds.angstrom-distribution.org"
DISTRO_CODENAME ?= "hardknott"

do_compile_append() {
    #no debug feed available so empty the feed configs
    echo "" >  ${S}/${sysconfdir}/opkg/debug-feed.conf

    #Hostmobility#
    echo "src/gz all http://www.hostmobility.org:8008/${DISTRO_CODENAME}/${MACHINE_ARCH}/all" >  ${S}/${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf
    echo "src/gz armv7ahf-vfp http://www.hostmobility.org:8008/${DISTRO_CODENAME}/${MACHINE_ARCH}/armv7ahf-neon" >>  ${S}/${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf
    echo "src/gz ${MACHINE_ARCH} http://www.hostmobility.org:8008/${DISTRO_CODENAME}/${MACHINE_ARCH}" >>  ${S}/${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf
}


