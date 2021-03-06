DESCRIPTION = "Configuration files for udhcpd (busybox)"
LICENSE = "CLOSED"


SRC_URI += "\
    file://udhcpd-eth0.conf \
    file://udhcpd-eth1.conf \
    file://udhcpd-eth2.conf \
"

do_install() {
    install -d ${D}${sysconfdir}

    install -m 0644 ${WORKDIR}/udhcpd-eth0.conf ${D}/${sysconfdir}/udhcpd-eth0.conf
    install -m 0644 ${WORKDIR}/udhcpd-eth1.conf ${D}/${sysconfdir}/udhcpd-eth1.conf
    install -m 0644 ${WORKDIR}/udhcpd-eth2.conf ${D}/${sysconfdir}/udhcpd-eth2.conf
}


FILES_${PN} = "${sysconfdir}/udhcpd-*.conf"
