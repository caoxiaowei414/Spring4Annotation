package com.cyh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.cyh.dao.BookDao;

/**
 * �Զ�װ��;
 * 		Spring��������ע�루DI������ɶ�IOC�������и��������������ϵ��ֵ��
 *
 * 1����@Autowired���Զ�ע�룺
 * 		1����Ĭ�����Ȱ�������ȥ�������Ҷ�Ӧ�����:applicationContext.getBean(BookDao.class);�ҵ��͸�ֵ
 * 		2��������ҵ������ͬ���͵�������ٽ����Ե�������Ϊ�����idȥ�����в���
 * 							applicationContext.getBean("bookDao")
 * 		3����@Qualifier("bookDao")��ʹ��@Qualifierָ����Ҫװ��������id��������ʹ��������
 * 		4�����Զ�װ��Ĭ��һ��Ҫ�����Ը�ֵ�ã�û�оͻᱨ��������ʹ��@Autowired(required=false);
 * 		5����@Primary����Spring�����Զ�װ���ʱ��Ĭ��ʹ����ѡ��bean��
 * 				��ʱ��Ҳ���Լ���ʹ��@Qualifierָ����Ҫװ���bean�����֣��Ҿ���������ȼ�
 *
 * 2����Spring��֧��ʹ��@Resource(JSR250)��@Inject(JSR330)[java�淶��ע��]
 * 		@Resource:
 * 			���Ժ�@Autowiredһ��ʵ���Զ�װ�书�ܣ�Ĭ���ǰ���������ƽ���װ��ģ�
 * 			û����֧�� @Primary ���ܣ�û��֧�� @Autowired��required=false��
 * 		@Inject:
 * 			��Ҫ����javax.inject�İ����� Autowired �Ĺ���һ����û�� required=false �Ĺ��ܣ�
 *
 *  @Autowired:Spring����ģ�@Resource��@Inject����java�淶
 *
 * AutowiredAnnotationBeanPostProcessor:��������Զ�װ�书�ܣ�
 *
 * 3����@Autowired: ���Ա��ڹ����������������������ԣ����Ǵ������л�ȡ���������ֵ
 * 		1������ע�ڷ���λ�ã�@Bean+���������������������л�ȡ��Ĭ�ϲ�д@AutowiredЧ����һ���ģ������Զ�װ��
 * 		2�������ڹ������ϣ�������ֻ��һ���вι�����������вι�������@Autowired����ʡ�ԣ�����λ�õ�������ǿ����Զ��������л�ȡ
 * 		3�������ڲ���λ�ã�
 *
 * 4�����Զ��������Ҫʹ��Spring�����ײ��һЩ�����ApplicationContext��BeanFactory��xxx����
 * 		�Զ������ʵ��xxxAware���ڴ��������ʱ�򣬻���ýӿڹ涨�ķ���ע����������Aware��
 * 		��Spring�ײ�һЩ���ע�뵽�Զ����Bean�У�
 * 		xxxAware������ʹ��xxxProcessor��
 * 			ApplicationContextAware --> ApplicationContextAwareProcessor��
 */
@Configuration
@ComponentScan(value = {"com.cyh.controller", "com.cyh.service", "com.cyh.dao", "com.cyh.bean"})
public class MainConfigOfAutowire {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLabel("customerized");
        return bookDao;
    }
}