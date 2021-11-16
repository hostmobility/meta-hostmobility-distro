#!/bin/sh
# resize the rootfs ext filesystem size to its full partition size
# usually used on first boot in a postinstall script
# or set in an autostart file from a postinstall script
#job done, remove it from systemd services
systemctl --no-reload disable resizefs.service



