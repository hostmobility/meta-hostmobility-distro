#Remove aufs-util not compatible for meta-virtualization layer and not needed use overlay2 instead of aufs.
RDEPENDS_${PN} = "curl git util-linux iptables \
                  ${@bb.utils.contains('DISTRO_FEATURES','systemd','','cgroup-lite',d)} \
                 "
RDEPENDS_${PN} += "virtual/containerd virtual/runc"