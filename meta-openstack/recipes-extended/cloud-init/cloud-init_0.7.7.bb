DESCRIPTION = "Init scripts for use on cloud images"
HOMEPAGE = "https://launchpad.net/cloud-init"
SECTION = "devel/python"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

PR = "r0"

SRC_URI = "https://launchpad.net/cloud-init/trunk/${PV}/+download/${BPN}-${PV}.tar.gz \
           file://cloud-init-source-local-lsb-functions.patch \
           file://distros-add-windriver-skeleton-distro-file.patch \
           file://cloud.cfg"

SRC_URI[md5sum] = "7511a05ac2684465b42ba448e2bb5616"
SRC_URI[sha256sum] = "d7b75e314ecdb99619014f21f3b622294a6c3bde248887dfb5e9cedb927ad0b0"

S = "${WORKDIR}/${BPN}-${PV}"

DISTUTILS_INSTALL_ARGS_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', '--init-system=sysvinit_deb', '', d)}"
DISTUTILS_INSTALL_ARGS_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '--init-system=systemd', '', d)}"

MANAGE_HOSTS ?= "False"
HOSTNAME ?= ""

do_install_prepend() {
    sed -e 's:/lib/${BPN}:${base_libdir}/${BPN}:' -i ${S}/setup.py
}

do_install_append() {
    install -m 0755 ${WORKDIR}/cloud.cfg ${D}${sysconfdir}/cloud/cloud.cfg

    sed -e "s:%MANAGE_HOSTS%:${MANAGE_HOSTS}:g" -i ${D}${sysconfdir}/cloud/cloud.cfg
    sed -e "s:%HOSTNAME%:${HOSTNAME}:g" -i ${D}${sysconfdir}/cloud/cloud.cfg

    ln -s ${libdir}/${BPN}/uncloud-init ${D}${sysconfdir}/cloud/uncloud-init
    ln -s ${libdir}/${BPN}/write-ssh-key-fingerprints ${D}${sysconfdir}/cloud/write-ssh-key-fingerprints
}

inherit setuptools3 update-rc.d

PACKAGES += "${PN}-systemd"

FILES_${PN} += "${sysconfdir}/* \
                ${datadir}/*"

FILES_${PN}-systemd += "${systemd_unitdir}/*"

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME_${BPN} = "cloud-init"

RDEPENDS_${PN} = "sysklogd \
                  python3 \
                 "
