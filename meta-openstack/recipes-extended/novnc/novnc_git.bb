DESCRIPTION = "HTML5 VNC client"
HOMEPAGE = "https://github.com/kanaka/noVNC"
SECTION = "web"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b428e7772bf00c07fb7b863b80358adf"

SRCREV = "9142f8f0f7b4a53447f5cfec3a797cbf0d6204a9"
PV = "1.2.0+git${SRCPV}"

SRC_URI = "git://github.com/kanaka/noVNC.git;protocol=https"

S = "${WORKDIR}/git"

do_compile() {
    :
}

RDEPENDS_${PN} += " \
	bash \
"

do_install() {
    install -m 755 -d ${D}${datadir}/novnc
   
    cp -R --no-dereference --preserve=mode,links ${S}/* ${D}${datadir}/novnc
    
    install -m 444 ${S}/vnc.html ${D}${datadir}/novnc/index.html
    install -m 444 ${S}/vnc_lite.html ${D}${datadir}/novnc/vnc_auto.html

    install -m 755 -d ${D}${bindir}
    install -m 644 ${S}/utils/launch.sh ${D}${bindir}/novnc_server
}

