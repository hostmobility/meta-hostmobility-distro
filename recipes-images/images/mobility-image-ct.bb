SUMMARY = "Based on Toradex Embedded Linux Demo with LXDE"
DESCRIPTION = "Angstrom-based image with the LXDE desktop environment"

LICENSE = "MIT"

#start of the resulting deployable tarball name
export IMAGE_BASENAME = "mobility-image-ct"

SYSTEMD_DEFAULT_TARGET = "graphical.target"

#create the deployment directory-tree
######require recipes-images/images/tdx-image-fstype.inc

IMAGE_LINGUAS = "en-us"

DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@oe.utils.conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'

CONMANPKGS ?= "connman connman-client connman-gnome"

#deploy the OpenGL ES headers to the sysroot
DEPENDS_append_tegra = " nvsamples"

IMAGE_BROWSER_extra = "firefox"
IMAGE_BROWSER = ""
#keep the rootfs size small
IMAGE_BROWSER_colibri-imx6ull = ""
IMAGE_BROWSER_colibri-vf = ""

# this would pull in a large amount of gst-plugins, we only add a selected few
#    gstreamer1.0-plugins-base-meta
#    gstreamer1.0-plugins-good-meta
#    gstreamer1.0-plugins-bad-meta
#    gst-ffmpeg
GSTREAMER = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-base-alsa \
    gstreamer1.0-plugins-base-audioconvert \
    gstreamer1.0-plugins-base-audioresample \
    gstreamer1.0-plugins-base-audiotestsrc \
    gstreamer1.0-plugins-base-typefindfunctions \
    gstreamer1.0-plugins-base-ogg \
    gstreamer1.0-plugins-base-theora \
    gstreamer1.0-plugins-base-videotestsrc \
    gstreamer1.0-plugins-base-vorbis \
    gstreamer1.0-plugins-good-audioparsers \
    gstreamer1.0-plugins-good-autodetect \
    gstreamer1.0-plugins-good-avi \
    gstreamer1.0-plugins-good-deinterlace \
    gstreamer1.0-plugins-good-id3demux \
    gstreamer1.0-plugins-good-isomp4 \
    gstreamer1.0-plugins-good-matroska \
    gstreamer1.0-plugins-good-multifile \
    gstreamer1.0-plugins-good-rtp \
    gstreamer1.0-plugins-good-rtpmanager \
    gstreamer1.0-plugins-good-udp \
    gstreamer1.0-plugins-good-video4linux2 \
    gstreamer1.0-plugins-good-wavenc \
    gstreamer1.0-plugins-good-wavparse \
"

# use gstreamer-0.10 for tegra
GSTREAMER_tegra = " \
    gstreamer \
    gst-plugins-base \
    gst-plugins-base-alsa \
    gst-plugins-base-audioconvert \
    gst-plugins-base-audioresample \
    gst-plugins-base-audiotestsrc \
    gst-plugins-base-decodebin \
    gst-plugins-base-decodebin2 \
    gst-plugins-base-playbin \
    gst-plugins-base-typefindfunctions \
    gst-plugins-base-ivorbisdec \
    gst-plugins-base-ogg \
    gst-plugins-base-theora \
    gst-plugins-base-videotestsrc \
    gst-plugins-base-vorbis \
    gst-plugins-good-audioparsers \
    gst-plugins-good-autodetect \
    gst-plugins-good-avi \
    gst-plugins-good-deinterlace \
    gst-plugins-good-id3demux \
    gst-plugins-good-isomp4 \
    gst-plugins-good-matroska \
    gst-plugins-good-rtp \
    gst-plugins-good-rtpmanager \
    gst-plugins-good-udp \
    gst-plugins-good-video4linux2 \
    gst-plugins-good-wavenc \
    gst-plugins-good-wavparse \
    gst-plugins-ugly-asf \
"

# Packages which might be empty or no longer available
RRECOMMENDS_${PN} += " \
    xserver-xorg-multimedia-modules \
    xserver-xorg-extension-dbe \
    xserver-xorg-extension-extmod \
"

IMAGE_INSTALL += " \
    gpio-tool \
    tegrastats-gtk \
    gnome-disk-utility \
    mime-support \
    eglinfo-x11 \
    xvinfo \
    tegrastats \
    tdx-nv-binaries \
    tdx-nv-binaries-nv-gstapps \
    tdx-nv-binaries-restricted-codecs \
    hdmi-hotplug \
    \
    file \
    aspell \
    kernel-modules \
    eject \
    gconf \
    gnome-vfs \
    gnome-vfs-plugin-file \
    gvfs \
    gvfsd-trash \
    xdg-utils \
    \
    libgsf \
    libxres \
    makedevs \
    xcursor-transparent-theme \
    zeroconf \
    angstrom-packagegroup-boot \
    packagegroup-basic \
    udev-extra-rules \
    ${CONMANPKGS} \
    ${ROOTFS_PKGMANAGE_PKGS} \
    timestamp-service \
    packagegroup-base-extended \
    ${XSERVER} \
    xserver-common \
    xauth \
    xhost \
    xset \
    setxkbmap \
    \
    xrdb \
    xorg-minimal-fonts xserver-xorg-utils \
    scrot \
    unclutter \
    \
    libxdamage libxvmc libxinerama \
    libxcursor \
    \
    florence3 \
    bash \
    \
    ${GSTREAMER} \
    v4l-utils \
    libpcre \
    libpcreposix \
    libxcomposite \
    alsa-states \
    ${IMAGE_BROWSER} \
    packagegroup-lxde-extended \
    \
    xinput-calibrator \
    \
    openbox \
    openbox-theme-clearlooks \
    openbox-theme-onyx \
    hicolor-icon-theme \
    lxdm \
    l3afpad \
    \
    wireless-regdb-static \
    \
    alsa-utils \
    alsa-utils-aplay \
    alsa-utils-amixer \
    \
    sqlite3 \
    \
    linux-firmware-ath9k \
    curl \
    canutils \
    nfs-utils-client \
    openssh-scp \
    openssh-sftp \
    \
    bzip2 \
    grep \
    joe \
    minicom \
    ldd \
    lsof \
    mtd-utils \
    dosfstools \
    util-linux-fstrim \
    \
    ethtool \
    hdparm \
    iperf3 \
    i2c-tools \
    libsoc \
    lmbench \
    memtester \
    nbench-byte \
    rt-tests \
    stress \
    util-linux-lsblk \
    \
    icu \
    libxslt \
    libsocketcan \
    iproute2 \
    iptables \
    ppp \
    openssl \
    libpng12 \
    xwd \
    mtd-utils-ubifs \
    linux-firmware-atheros-license \
    rsync \
    dhcp-client \
    make \
    fbtest \
    packagegroup-hostmobility-base \
"

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "busybox shadow"

inherit core-image
