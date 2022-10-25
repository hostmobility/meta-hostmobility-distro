FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://hostapd_custom.conf \
"
SYSTEMD_SERVICE_${PN} = "hostapd.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

do_install_append() {
    install -m 0644 ${WORKDIR}/hostapd_custom.conf ${D}${sysconfdir}/hostapd_custom.conf
}

FILES_${PN} += "${sysconfdir}/hostapd_custom.conf"