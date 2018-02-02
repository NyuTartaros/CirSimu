package cirsimu.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class DocUtil {
    public Configuration configure=null;
    
    public DocUtil(){
        configure=new Configuration(Configuration.VERSION_2_3_22);
        configure.setDefaultEncoding("utf-8");
    }
    /**
     * ����freemaker��ܣ�����ģ�������ļ�
     * @param dataMap ��Ҫ����ģ�������
     * @param downloadType �ļ�����
     * @param savePath ����·��
     */
    public void createDoc(Map<String,Object> dataMap,String downloadType,File file){
        try {
            //������Ҫװ���ģ��
            Template template=null;
            //����ģ��װ�÷�����·����FreeMarker֧�ֶ���ģ��װ�ط�����������servlet��classpath,���ݿ�װ�ء�
            //����ģ���ļ�������testDoc��
            configure.setClassForTemplateLoading(this.getClass(), "/cirsimu/resource");
            //���ö����װ��
//            configure.setObjectWrapper(new DefaultObjectWrapper());
            //�����쳣������
            configure.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
            //����Template����ע��ģ������������downloadTypeҪһ��
            template=configure.getTemplate(downloadType+".xml");
            File outFile=file;
            Writer out=null;
            out=new BufferedWriter(new OutputStreamWriter(
            		new FileOutputStream(outFile), "utf-8"));
            template.process(dataMap, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
    
}