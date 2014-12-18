create index IX_93902D0A on LinkShortener_Link (autoGen);
create index IX_BFFB2B72 on LinkShortener_Link (shortLink, autoGen);
create index IX_3E052EED on LinkShortener_Link (uuid_);
create unique index IX_B471C05D on LinkShortener_Link (uuid_, groupId);