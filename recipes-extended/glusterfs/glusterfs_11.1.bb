SRC_URI = "https://bits.gluster.org/pub/gluster/glusterfs/src/${BPN}-${PV}.tar.gz"

SRC_URI[md5sum] = "7e290a50026752f435f694651687e0f2"
SRC_URI[sha256sum] = "6a31b8450d02cd12f47f4571c031e9d6b8705279a0e8970ae9a05e1c87dffb76"

require glusterfs.inc
