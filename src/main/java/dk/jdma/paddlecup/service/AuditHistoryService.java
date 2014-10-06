package dk.jdma.paddlecup.service;

public interface AuditHistoryService {
    public <T> T findAuditByRevision(Class<T> clazz, Long id, int revision);
}
