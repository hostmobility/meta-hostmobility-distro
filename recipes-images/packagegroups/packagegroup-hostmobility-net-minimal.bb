SUMMARY = "Networking package group"
DESCRIPTION = "Package group bringing in packages for a minimal network manager framework"

inherit packagegroup

PACKAGES = "\
    packagegroup-hostmobility-net-minimal \
    "

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} += "\
    init-ifupdown \
    \
    ifplugd-conf \
    ifplugd-conf-systemd-eth0 \
    ifplugd-conf-systemd-eth1 \
    ifplugd-conf-systemd-eth2 \
    \
    udhcpd-conf \
    ppp \
    ntpdate \
"

